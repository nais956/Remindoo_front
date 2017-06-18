package fr.taches.jms;

import java.util.HashMap;
import java.util.Map;

import fr.taches.domain.Demande;

public class DemandesEnCours {

	private static DemandesEnCours INSTANCE = new DemandesEnCours(); // Singleton pattern
	private Map<Long,Demande> demandes = new HashMap<Long,Demande>();
	private long compteur = 0;

	public static DemandesEnCours getInstance() { // Singleton pattern
		return INSTANCE;
	}

	public long posterDemande(Demande demande) {
		synchronized(this) {
			compteur = compteur + 1;
			demandes.put(compteur, demande);
			demande.setNumero(compteur);
			return compteur;
		}
	}

	public Demande getDemande(long numero) {
		return demandes.get(numero);
	}
}
