package fr.taches.web;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity

public class Liste {
	@Id
    @GeneratedValue
	private int idListe;
	
	private String nom;
	
	@ManyToOne
    private Utilisateur utilisateur;


	public Liste() {

	}
	
	@OneToMany(mappedBy = "liste")
	private List<Note> note;
	
	public int getIdListe() {
		return idListe;
	}
	public void setIdListe(int idListe) {
		this.idListe = idListe;
	}

	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}
	public List<Note> getNote() {
		return note;
	}
	public void setNote(List<Note> note) {
		this.note = note;
	}
	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
	
	
}
