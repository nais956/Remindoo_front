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
import fr.taches.domain.Tache;
import fr.taches.domain.TypeTache;
import fr.taches.service.ServiceListe;

@RestController
public class ControllerListeTaches {
	
	@Autowired
	private ServiceListe ServiceListe;
	

    @RequestMapping(value = "/{idListe}/tache", method = RequestMethod.POST)
    public Tache postTache(@RequestBody Tache tache, @PathVariable("idListe") Long idListe) {  	
    	Liste liste = ServiceListe.findById(idListe);
    	TypeTache typeTache = ServiceListe.findTypeTacheById(tache.getTypeTache().getId());
    	tache.setListe(liste);
    	tache.setTypeTache(typeTache);
        ServiceListe.createTache(tache);
        return tache;
    }  
    
    @RequestMapping(value = "/tache/{idTache}", method = RequestMethod.POST)
    public void updateTache(@RequestBody Tache tache, @PathVariable("idTache") Long idTache){
    	TypeTache typeTache = ServiceListe.findTypeTacheById(tache.getTypeTache().getId());
    	tache.setTypeTache(typeTache);
    	ServiceListe.updateTache(tache, idTache);
    }
    
    @RequestMapping(value = "/deleteTache/{idTache}", method = RequestMethod.DELETE)
    public void  deleteTache(@PathVariable("idTache") Long idTache){
    	ServiceListe.deleteTache(idTache);
    }
        
}


