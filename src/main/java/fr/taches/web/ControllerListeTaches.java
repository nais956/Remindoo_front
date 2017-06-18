package fr.taches.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.taches.domain.Demande;
import fr.taches.domain.Tache;
import fr.taches.jms.DemandesEnCours;
import fr.taches.jms.Producer;

@RestController
public class ControllerListeTaches {
	
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

    @RequestMapping(value = "/{idListe}/tache", method = RequestMethod.POST)
    public Tache postTache(@RequestBody Tache tache, @PathVariable("idListe") Long idListe) {
    	System.out.println("***** postTache *****");
    	demande = new Demande("postTache", idListe, tache);
		envoiAvecRetour();
		return (Tache)demande.getReponse();
    }  
    
    @RequestMapping(value = "/tache/{idTache}", method = RequestMethod.POST)
    public void updateTache(@RequestBody Tache tache, @PathVariable("idTache") Long idTache){
    	System.out.println("***** updateTache *****");
    	demande = new Demande("updateTache", idTache, tache);
		envoiSimple();
    }
    
    @RequestMapping(value = "/deleteTache/{idTache}", method = RequestMethod.DELETE)
    public void  deleteTache(@PathVariable("idTache") Long idTache){
    	System.out.println("***** deleteTache *****");
    	demande = new Demande("deleteTache", idTache);
		envoiSimple();
    }
        
}


