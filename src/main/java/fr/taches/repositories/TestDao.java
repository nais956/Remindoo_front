package fr.taches.repositories;


import fr.taches.domain.*;


import java.util.List;




public interface TestDao {
	
	
	
	List<Note> listNote();
	
	 Long save(Note Note);
	
	void saveNote(Note newNote);

	
	
}