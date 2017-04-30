package fr.taches.web;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity

public class TypeTache {
	
	@Id
    @GeneratedValue
	private int idTypeTache;
	private String nom;
	
	@Enumerated(EnumType.STRING)
	private Categorie categorie;
	

	public int getIdTypeTache() {
		return idTypeTache;
	}
	public void setIdTypeTache(int idTypeTache) {
		this.idTypeTache = idTypeTache;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}

	
	
}
