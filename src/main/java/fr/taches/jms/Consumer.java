package fr.taches.jms;

import javax.jms.JMSException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.stereotype.Component;

import fr.taches.domain.Note;
import fr.taches.service.ServiceListe;

@Component
public class Consumer {

	
	
    @Autowired
    JmsTemplate jmsTemplate;
	
    @Autowired
    ServiceListe serviceListe;
     
    public void receiveMessage(final Message<Note> message) throws JMSException {

        MessageHeaders headers =  message.getHeaders();
         
        Note response = message.getPayload();
         
        serviceListe.createNote(response); 
    }
}