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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import fr.taches.domain.Liste;
import fr.taches.domain.Note;
import fr.taches.service.ServiceListe;

@RestController
public class ControllerListeNotes {
	
	@Autowired
	private ServiceListe ServiceListe;
	
	
    
    @RequestMapping(value = "/voirNote/{idNote}", method = RequestMethod.GET)
    public Note  getNote(@PathVariable("idNote") Long idNote) {
        return ServiceListe.findNoteById(idNote);
    }


    @RequestMapping(value = "/{idListe}/note", method = RequestMethod.POST)
    public Note postNote(@RequestBody Note note, @PathVariable("idListe") Long idListe) {  	
    	Liste liste = ServiceListe.findById(idListe);
    	note.setListe(liste);
        ServiceListe.createNote(note);
        return note;
     
    }  
    
    @RequestMapping(value = "/note/{idNote}", method = RequestMethod.POST)
    public void updateNote(@RequestBody Note note, @PathVariable("idNote") Long idNote){
    	ServiceListe.updateNote(note, idNote);
    }
    
    @RequestMapping(value = "/deleteNote/{idNote}", method = RequestMethod.DELETE)
    public void  deleteNote(@PathVariable("idNote") Long idNote){
    	ServiceListe.deleteNote(idNote);
    }
        
}


