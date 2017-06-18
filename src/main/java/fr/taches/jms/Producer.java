package fr.taches.jms;

import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
import javax.jms.Session;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import fr.taches.domain.Demande;

@Component
public class Producer {


	private ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContextJMS.xml");
	private QueueConnectionFactory factory = (QueueConnectionFactory) applicationContext.getBean("connectionFactory");
	private Queue queue = (Queue) applicationContext.getBean("queueDemandes");
	private QueueConnection connection;
	private QueueSession session;
	private ObjectMessage message;
	private QueueSender sender;
	
	public void sendDemande(Demande demande) {

		try{

			// connection au message broker
			connection = factory.createQueueConnection();
			
			// ouvrir session sans transaction (1 seul message) et acquitement automatique
			session = connection.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
			connection.start();
			
			// créer et envoyer message
			message = session.createObjectMessage(demande);
			sender = session.createSender(queue);
			sender.send(message);

			// fermer la connexion
			session.close();
			connection.close();

		}catch(Exception e){e.printStackTrace();}



		/*jmsTemplate.send(new MessageCreator(){
                @Override
                public Message createMessage(Session session) throws JMSException{
                    ObjectMessage objectMessage = session.createObjectMessage((Serializable) demande);
                    return objectMessage;
                }
        });*/  
	}
}