package fr.taches.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.taches.dao.TestDao;
import fr.taches.domain.*;
import fr.taches.jms.Consumer;
import fr.taches.jms.Producer;

@Service
public class ServiceListeImpl implements ServiceListe {

    @Autowired
    private TestDao testDao;

    
    @Autowired
    Consumer jmsConsumer;
     
    @Autowired
    Producer jmsProducer;

    @Override
    public List<Note> listNote() {
        return testDao.findAll();
        
}


	@Override
	public void createNote(Note newNote) {
		jmsProducer.sendMessage(newNote);
        testDao.saveOrUpdate(newNote);
		
	}

}