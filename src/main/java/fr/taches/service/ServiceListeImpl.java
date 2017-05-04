package fr.taches.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.taches.dao.TestDao;
import fr.taches.domain.*;

@Service
public class ServiceListeImpl implements ServiceListe {

    @Autowired
    private TestDao testDao;


    @Override
    public List<Note> listNote() {
        return testDao.findAll();
        
}


	@Override
	public void createNote(Note newNote) {
        testDao.saveOrUpdate(newNote);
		
	}

}