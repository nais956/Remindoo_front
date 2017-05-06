package fr.taches.jms;

import java.io.Serializable;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.jms.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

import fr.taches.domain.Note;

@Component
public class Producer {
	
    @Autowired
    JmsTemplate jmsTemplate;
     


    public void sendMessage(final Note note) {
 
        jmsTemplate.send(new MessageCreator(){
                @Override
                public Message createMessage(Session session) throws JMSException{
                    ObjectMessage objectMessage = session.createObjectMessage((Serializable) note);
                    return objectMessage;
                }
            });
    }
}