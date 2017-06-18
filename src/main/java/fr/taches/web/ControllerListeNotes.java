package fr.taches.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.taches.domain.Demande;
import fr.taches.domain.Note;
import fr.taches.jms.DemandesEnCours;
import fr.taches.jms.Producer;

@RestController
public class ControllerListeNotes {

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


	@RequestMapping(value = "/voirNote/{idNote}", method = RequestMethod.GET)
	public Note getNote(@PathVariable("idNote") Long idNote) {
		System.out.println("***** getNote *****");
		demande = new Demande("getNote", idNote);
		envoiAvecRetour();
		return (Note)demande.getReponse();
	}


	@RequestMapping(value = "/{idListe}/note", method = RequestMethod.POST)
	public Note postNote(@RequestBody Note note, @PathVariable("idListe") Long idListe) {
		System.out.println("***** postNote *****");
		demande = new Demande("postNote", idListe, note);
		envoiAvecRetour();
		return (Note)demande.getReponse();
	}


	@RequestMapping(value = "/note/{idNote}", method = RequestMethod.POST)
	public void updateNote(@RequestBody Note note, @PathVariable("idNote") Long idNote){
		System.out.println("***** updateNote *****");
		demande = new Demande("updateNote", idNote, note);
		envoiSimple();
	}

	@RequestMapping(value = "/deleteNote/{idNote}", method = RequestMethod.DELETE)
	public void  deleteNote(@PathVariable("idNote") Long idNote){
		System.out.println("***** deleteNote *****");
		demande = new Demande("deleteNote", idNote);
		envoiSimple();
	}

}


