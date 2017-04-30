package fr.taches.web;



import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity


public class Tache extends Note {


	public Tache() {
		super();
		// TODO Auto-generated constructor stub
	}

	@ManyToOne
	private TypeTache typeTache;
	
	
	public TypeTache getTypeTache() {
		return typeTache;
	}


	public void setTypeTache(TypeTache typeTache) {
		this.typeTache = typeTache;
	}






	
	

}
