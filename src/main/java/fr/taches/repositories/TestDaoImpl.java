package fr.taches.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import fr.taches.domain.Note;
import fr.taches.domain.Liste;

@Component
@Transactional
public class TestDaoImpl implements TestDao {

    @PersistenceContext
    private EntityManager em;


    public List<Note> listNote() {
        return em.createQuery("FROM Note", Note.class).getResultList();
    }


	@Override
	public void saveNote(Note newNote) {
		 save(newNote);
	}


	@Override
	public Long save(Note note) {
        em.persist(note);
        return note.getId();
	}

    

   
}