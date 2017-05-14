package fr.taches.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import fr.taches.domain.*;
import fr.taches.jms.Consumer;
import fr.taches.jms.Producer;
import fr.taches.repository.NoteRepository;

@Service
public class ServiceListeImpl implements ServiceListe {

    @Autowired
    private NoteRepository noteRepository;

    
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


}