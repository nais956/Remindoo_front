package fr.taches.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.taches.domain.*;
import fr.taches.repositories.TestDao;

@Service
public class ServiceListeImpl implements ServiceListe {

    @Autowired
    private TestDao testDao;


    @Override
    public List<Note> listNote() {
        return testDao.listNote();
        
}


	@Override
	public void createNote(Note newNote) {
        testDao.saveNote(newNote);
		
	}

}