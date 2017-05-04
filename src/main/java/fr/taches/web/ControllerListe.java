package fr.taches.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import fr.taches.domain.Note;
import fr.taches.service.ServiceListe;

@RestController
@CrossOrigin
public class ControllerListe {
	
	@Autowired
	private ServiceListe ServiceListe;
	
    @RequestMapping(value = "/notes", method = RequestMethod.GET)
    public List<Note>  getNotes() {
        return ServiceListe.listNote();
    }

	
    @RequestMapping(value = "/note", method = RequestMethod.POST)
    public Note postNote(@RequestBody Note note) {
    	Note newNote = new Note.Builder()
                .withNom(note.getNom())
                .withTexte(note.getTexte())
                .withListe(note.getListe())
                .build();
        ServiceListe.createNote(newNote);
        return newNote;
}

}