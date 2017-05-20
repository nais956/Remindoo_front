package fr.taches.web;

public class Reponse {

	
	private Object data;
	
	 // ---------------constructeurs
	public Reponse() {
	}
	
	public Reponse(Object data) {
	this.setData(data);
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
	
}
