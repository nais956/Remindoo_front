package fr.taches.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import fr.taches.domain.Note;

@Component
public interface NoteRepository extends JpaRepository<Note, Long> {
	Note findByNom(String nom);


}
