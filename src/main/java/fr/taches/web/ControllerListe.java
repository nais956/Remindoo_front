package fr.taches.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import org.springframework.web.bind.annotation.RestController;

import fr.taches.domain.Liste;
import fr.taches.domain.Note;
import fr.taches.domain.Tache;
import fr.taches.service.ServiceListe;

@RestController
public class ControllerListe {
	
	@Autowired
	private ServiceListe ServiceListe;
	
    @RequestMapping(value = "/listes", method = RequestMethod.GET)
    public List<Liste>  getListes() {
        return ServiceListe.listListe();
    }

	
    @RequestMapping(value = "/liste", method = RequestMethod.POST)
    public Liste postListe(@RequestBody Liste liste) {
    	/*Liste newListe = new Liste.Builder()
                .withNom(liste.getNom())
                .withUtilisateur(liste.getUtilisateur())
                .build();*/
        ServiceListe.createListe(liste);
        return liste;
    }
    
    @RequestMapping(value = "/liste/{idListe}", method = RequestMethod.POST)
    public void updateListe(@RequestBody Liste liste, @PathVariable("idListe") Long idListe){
    	ServiceListe.updateListe(liste, idListe);
    }
    
    @RequestMapping(value = "/deleteListe/{idListe}", method = RequestMethod.DELETE)
    public void  deleteListe(@PathVariable("idListe") Long idListe){
    	List<Note> listeElements = ServiceListe.getAllElements(idListe);
    	for(Note note : listeElements){
    		ServiceListe.deleteNote(note.getId());
    	}
    	ServiceListe.deleteListe(idListe);
    }
    
    @RequestMapping(value = "/getAllNotes/{idListe}", method = RequestMethod.GET)
    public List<Note> getAllNotes(@PathVariable("idListe") Long idListe) {
		return ServiceListe.getAllNotes(idListe);
    }
    
    
    
    @RequestMapping(value = "/getAllTaches/{idListe}", method = RequestMethod.GET)
    public List<Tache> getAllTaches(@PathVariable("idListe") Long idListe) {
		return ServiceListe.getAllTaches(idListe);
    }
   
}