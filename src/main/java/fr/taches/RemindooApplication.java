package fr.taches;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;



import fr.taches.web.Note;


public class RemindooApplication {

	public static void main(String[] args) {
	
		//Connexion à la BDD
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("manager1");
		EntityManager entityManager = emf.createEntityManager();
		
		EntityTransaction tx = entityManager.getTransaction();
		
    	try{
    		
			tx.begin();
			
			Note note = new Note();
			note.setNom("Note1");
					
			
			entityManager.persist(note);
				
			tx.commit();			
		
		}catch(Exception e){
			tx.rollback();
		}
		
	}
}

