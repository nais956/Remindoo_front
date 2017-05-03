package fr.taches.web;

import fr.taches.domain.Liste;

public class Note {

	private int id;
	private String nom;
	private String texte;
	
	

	private Liste liste;
	
	
	public Note(int id, String nom, String texte) {
		super();
		this.id = id;
		this.nom = nom;
		this.texte = texte;
	}
	
	
	public Note() {
		super();// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getTexte() {
		return texte;
	}
	public void setTexte(String texte) {
		this.texte = texte;
	}
	
	
}