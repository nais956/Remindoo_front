package fr.taches.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.taches.domain.Demande;
import fr.taches.domain.Liste;
import fr.taches.domain.Note;
import fr.taches.domain.Tache;
import fr.taches.jms.DemandesEnCours;
import fr.taches.jms.Producer;

@RestController
public class ControllerListe {
	
	@Autowired
	private Producer producer;

	private DemandesEnCours demandesencours = DemandesEnCours.getInstance();
	private Demande demande;

	private void envoiSimple() {
		producer.sendDemande(demande);
	}

	private void envoiAvecRetour() {
		demandesencours.posterDemande(demande);
		producer.sendDemande(demande);
		attenteRetour();
	}

	private void attenteRetour() {
		synchronized(demande) {
			try {
				while (!demande.isDisponible())
					demande.wait();
			} catch (InterruptedException e) {e.printStackTrace();}
		}
	}
	
    @SuppressWarnings("unchecked")
	@RequestMapping(value = "/listes", method = RequestMethod.GET)
    public List<Liste>  getListes() {
		System.out.println("***** getListes *****");
		demande = new Demande("getListes");
		envoiAvecRetour();
		return (List<Liste>)demande.getContenu();
    }

    @RequestMapping(value = "/liste", method = RequestMethod.POST)
    public Liste postListe(@RequestBody Liste liste) {
		System.out.println("***** postListe *****");
		demande = new Demande("postListe");
		envoiAvecRetour();
		return (Liste)demande.getContenu();
    }
    
    @RequestMapping(value = "/liste/{idListe}", method = RequestMethod.POST)
    public void updateListe(@RequestBody Liste liste, @PathVariable("idListe") Long idListe){
		System.out.println("***** updateListe *****");
		demande = new Demande("updateListe", idListe, liste);
		envoiSimple();
    }
    
    @RequestMapping(value = "/deleteListe/{idListe}", method = RequestMethod.DELETE)
    public void  deleteListe(@PathVariable("idListe") Long idListe){
    	System.out.println("***** deleteListe *****");
    	demande = new Demande("deleteListe", idListe);
		envoiSimple();
    }
    
    @SuppressWarnings("unchecked")
	@RequestMapping(value = "/getAllNotes/{idListe}", method = RequestMethod.GET)
    public List<Note> getAllNotes(@PathVariable("idListe") Long idListe) {
    	System.out.println("***** getAllNotes *****");
    	demande = new Demande("getAllNotes", idListe);
		envoiAvecRetour();
		return (List<Note>)demande.getReponse();
    }
    
    
    
    @SuppressWarnings("unchecked")
	@RequestMapping(value = "/getAllTaches/{idListe}", method = RequestMethod.GET)
    public List<Tache> getAllTaches(@PathVariable("idListe") Long idListe) {
    	System.out.println("***** getAllTaches *****");
    	demande = new Demande("getAllTaches", idListe);
		envoiAvecRetour();
		return (List<Tache>)demande.getReponse();
    }
   
}