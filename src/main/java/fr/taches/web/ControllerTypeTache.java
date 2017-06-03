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

import fr.taches.domain.Categorie;
import fr.taches.domain.TypeTache;
import fr.taches.service.ServiceListe;

@RestController
public class ControllerTypeTache {
	
	@Autowired
	private ServiceListe ServiceListe;
	
	
    @RequestMapping(value = "/typesTache", method = RequestMethod.GET)
    public List<TypeTache>  getTypeTaches() {
        return ServiceListe.listTypeTache();
    }

    @RequestMapping(value = "/typeTache", method = RequestMethod.POST)
    public TypeTache postTypeTache(@RequestBody TypeTache typeTache) {  
    	Categorie categorie = typeTache.getCategorie();
    	typeTache.setCategorie(categorie);
        ServiceListe.createTypeTache(typeTache);
        return typeTache;
    }  
    
    @RequestMapping(value = "/categorie", method = RequestMethod.GET)
    public Categorie[] getCategories() {  	
        return ServiceListe.listCategories();
    }  
    
    @RequestMapping(value = "/typeTache/{idTypeTache}", method = RequestMethod.POST)
    public void updateTypeTache(@RequestBody TypeTache typeTache, @PathVariable("idTypeTache") Long idTypeTache){
    	ServiceListe.updateTypeTache(typeTache, idTypeTache);
    }
    
    @RequestMapping(value = "/deleteTypeTache/{idTypeTache}", method = RequestMethod.DELETE)
    public void  deleteTypeTache(@PathVariable("idTypeTache") Long idTypeTache){
    	ServiceListe.deleteTypeTache(idTypeTache);
    }
        
}


