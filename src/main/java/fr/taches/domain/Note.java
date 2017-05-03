package fr.taches.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Note")
public class Note {
	@Id
    @GeneratedValue
	private int id;
	private String nom;
	private String texte;
	
	
	@ManyToOne
	private Liste liste;
	
	public Note(int id, String nom, String texte) {
		super();
		this.id = id;
		this.nom = nom;
		this.texte = texte;
	}
	
	
	public Note(fr.taches.web.Note note) {
		this.id = note.getId();
		this.nom = note.getNom();
		this.texte = note.getTexte();
	}
	
	

	public Note() {
		// TODO Auto-generated constructor stub
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
