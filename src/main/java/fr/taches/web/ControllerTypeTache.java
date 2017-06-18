package fr.taches.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.taches.domain.Categorie;
import fr.taches.domain.Demande;
import fr.taches.domain.TypeTache;
import fr.taches.jms.DemandesEnCours;
import fr.taches.jms.Producer;

@RestController
public class ControllerTypeTache {

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
	@RequestMapping(value = "/typesTache", method = RequestMethod.GET)
	public List<TypeTache>  getTypeTaches() {
		System.out.println("***** getTypeTaches *****");
		demande = new Demande("getTypeTaches");
		envoiAvecRetour();
		return (List<TypeTache>)demande.getReponse();
	}

	@RequestMapping(value = "/typeTache", method = RequestMethod.POST)
	public TypeTache postTypeTache(@RequestBody TypeTache typeTache) {
		System.out.println("***** postTypeTache *****");
		demande = new Demande("postTypeTache", 0, typeTache);
		envoiAvecRetour();
		return (TypeTache)demande.getReponse();
	}  

	@RequestMapping(value = "/categorie", method = RequestMethod.GET)
	public Categorie[] getCategories() {
		System.out.println("***** getCategories *****");
		demande = new Demande("getCategories");
		envoiAvecRetour();
		return (Categorie[])demande.getReponse();
	}  

	@RequestMapping(value = "/typeTache/{idTypeTache}", method = RequestMethod.POST)
	public void updateTypeTache(@RequestBody TypeTache typeTache, @PathVariable("idTypeTache") Long idTypeTache){
		System.out.println("***** updateTypeTache *****");
		demande = new Demande("updateTypeTache", idTypeTache, typeTache);
		envoiSimple();
	}

	@RequestMapping(value = "/deleteTypeTache/{idTypeTache}", method = RequestMethod.DELETE)
	public void  deleteTypeTache(@PathVariable("idTypeTache") Long idTypeTache){
		System.out.println("***** deleteTypeTache *****");
		demande = new Demande("deleteTache", idTypeTache);
		envoiSimple();
	}

}


