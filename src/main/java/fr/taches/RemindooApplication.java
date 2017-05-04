package fr.taches;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.swing.JFrame;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import fr.taches.domain.Note;


@SpringBootApplication
public class RemindooApplication extends JFrame {

	public static void main(String[] args) {
	
		SpringApplication.run(RemindooApplication.class, args);
	}
}

