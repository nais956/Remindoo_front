package fr.taches.jms;

import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueReceiver;
import javax.jms.QueueSession;
import javax.jms.Session;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import fr.taches.domain.Demande;

public class Consumer implements Runnable {

	private ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContextJMS.xml");
	private QueueConnectionFactory factory = (QueueConnectionFactory) applicationContext.getBean("connectionFactory");
	private Queue queue = (Queue) applicationContext.getBean("queueReponses");
	private QueueConnection connection;
	private QueueSession session;
	private ObjectMessage message;
	private Demande reponse;
	private DemandesEnCours demandesencours = DemandesEnCours.getInstance();
	private Demande demande;


	public void run() {
		try{
			System.out.println("***** Consumer lanc� *****");
			// connection au message broker
			connection = factory.createQueueConnection();

			// ouvrir session sans transaction (1 seul message) et acquitement automatique
			session = connection.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
			connection.start();

			QueueReceiver receiver = session.createReceiver(queue);

			// r�ception et traitement des r�ponses
			while(true) {
				message = (ObjectMessage) receiver.receive();	// bloque sur attente message
				System.out.println("***** Message re�u *****");
				reponse = (Demande) message.getObject();
				demande = demandesencours.getDemande(reponse.getNumero());
				if (!(demande == null) ) {
					synchronized (demande) {
						demande.setReponse(reponse.getReponse());
						demande.setDisponible();
						demande.notifyAll();
					}
				}
				System.out.println("***** Message trait� *****");
			}
		}catch(Exception e){e.printStackTrace();}
	}

}