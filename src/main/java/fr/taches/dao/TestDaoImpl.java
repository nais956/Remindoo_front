package fr.taches.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import fr.taches.domain.Note;
import fr.taches.repository.NoteRepository;
import fr.taches.domain.Liste;

@Component
@Transactional
public class TestDaoImpl implements TestDao {


    @Autowired
    NoteRepository noteRepository;

    
    public List<Note> findAll() {
        return noteRepository.findAll(new Sort(new Sort.Order(Sort.Direction.ASC, "id")));
}


	public Note saveOrUpdate(Note newNote) {
		return noteRepository.save(newNote);
	}



    

   
}