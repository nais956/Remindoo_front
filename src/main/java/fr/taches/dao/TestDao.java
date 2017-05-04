package fr.taches.dao;


import fr.taches.domain.*;


import java.util.List;




public interface TestDao {
	
	
	
	List<Note> findAll();
	
	
	Note saveOrUpdate(Note newNote);

	
	
}