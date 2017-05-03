package fr.taches.web;

import java.util.List;


import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import fr.taches.service.ServiceListe;

@Controller
public class ControllerListe {

	ServiceListe ServiceListe = new  ServiceListe();
	
	@RequestMapping(value="/Notes", method=RequestMethod.GET)
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	public List<Note> getListeNote(){		
		return ServiceListe.listerNotes();
	}

	@RequestMapping(value="/Note", method=RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	public void addNoteParBodyHTTP(@RequestBody Note Note){
		ServiceListe.ajouterNote(Note);
	}
	
	@RequestMapping(value="/Note", method=RequestMethod.PUT)
	@ResponseStatus(HttpStatus.OK)
	public void modifierNote( @RequestBody Note Note){
		System.out.println("modifierNote : " + Note);
		// ...
	}
	
	@RequestMapping(value="/Note", method=RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	public void deleteNote( @RequestBody Note Note){
		System.out.println("deleteNote : " + Note);

	}
	


}