package fr.taches.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import fr.taches.domain.*;
import fr.taches.jms.Consumer;
import fr.taches.jms.Producer;
import fr.taches.repository.ListeRepository;
import fr.taches.repository.NoteRepository;
import fr.taches.repository.TacheRepository;



@Service
public class ServiceListeImpl implements ServiceListe {

    @Autowired
    private NoteRepository noteRepository;
    
    @Autowired
    private ListeRepository listeRepository;
    
    @Autowired
    private TacheRepository tacheRepository;
    
    @Autowired
    Consumer jmsConsumer;
     
    @Autowired
    Producer jmsProducer;

    @Async
    @Override
    public List<Note> listNote() {
        return noteRepository.findAll(new Sort(new Sort.Order(Sort.Direction.ASC, "id")));  
    }

    @Async
	@Override
	public void createNote(Note newNote) {
    	noteRepository.save(newNote);
	}
    
    @Async
	@Override
	public List<Liste> listListe() {
        return listeRepository.findAll(new Sort(new Sort.Order(Sort.Direction.ASC, "id")));
	}
    
    @Async
	@Override
	public void createListe(Liste newListe) {
		listeRepository.save(newListe);
		
	}

	@Override
	public List<Note> getAllNotes(Long idListe) {
		return noteRepository.getNotebyListe(idListe);
	}
	
	public Liste findById(Long idListe){
		return listeRepository.findById(idListe);
	}
	
	
	@Override
	public List<Tache> getAllTaches(Long idListe) {
		return tacheRepository.getTachebyListe(idListe);
	}
	
	public void updateListe(Liste listeUpdated, Long idListe) {
		Liste liste = listeRepository.findOne(idListe);
		liste.setNom(listeUpdated.getNom());
		listeRepository.save(liste);
	}

	@Override
	public void deleteListe(Long idListe) {
		listeRepository.delete(idListe);
	};



	@Override
	public Note findNoteById(Long idNote) {
		return noteRepository.findById(idNote);
	}

	@Override
	public void updateNote(Note noteUpdated, Long idNote) {
		Note note = noteRepository.findOne(idNote);
		note.setNom(noteUpdated.getNom());
		note.setTexte(noteUpdated.getTexte());
		noteRepository.save(note);
		
	}

	@Override
	public void deleteNote(Long idNote) {
		noteRepository.delete(idNote);
	}

}