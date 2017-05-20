package fr.taches.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import fr.taches.domain.Liste;
import fr.taches.domain.Note;
import fr.taches.domain.Tache;

public interface ServiceListe {


		List<Liste> listListe();
		void createListe(Liste newListe);
		Liste findById(Long idListe);	
		void deleteListe(Long idListe);
		public void updateListe(Liste liste, Long idListe);
		
		
		List<Note> listNote();
		List<Note> getAllNotes(Long idListe);
		void createNote(Note newNote);
		Note findNoteById(Long idNote);
		void updateNote(Note note, Long idNote);
		void deleteNote(Long idNote);
		
		List<Tache> getAllTaches(Long idListe);
}
