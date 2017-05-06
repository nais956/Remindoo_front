package fr.taches.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import fr.taches.domain.Note;

public interface ServiceListe {


		List<Note> listNote();

		
		void createNote(Note newNote);
		

	}
	
	/*
	EntityManager entityManager;
	
	public ServiceListe(){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("manager1");
		entityManager = emf.createEntityManager();
	}
	
	public void ajouterNote(fr.taches.web.Note Note){
		fr.taches.domain.Note NoteJPA = new fr.taches.domain.Note(Note);
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		entityManager.persist(NoteJPA);
		tx.commit();
	}
	

	public List<fr.taches.web.Note> listerNotes(){
		List notesJPA = entityManager.createQuery("select n from Note n").getResultList();
		List<fr.taches.web.Note> NotesDTO = new ArrayList<fr.taches.web.Note>();
		fr.taches.domain.Note jpa;
		for(int i=0; i<notesJPA.size(); i++){
			jpa = (Note) notesJPA.get(i);
			fr.taches.web.Note dto = new fr.taches.web.Note(jpa.getId(), jpa.getNom(), jpa.getTexte());
			NotesDTO.add(dto);
		}
		return NotesDTO;
	}

	
	
}*/
