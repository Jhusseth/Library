package model;

public class NodeClient {
	
	private int dato;
	private NodeClient next;
	

	public NodeClient(int  dato) {
		this.dato=dato;
		next=null;
	}


	public int getDato() {
		return dato;
	}


	public void setDato(int dato) {
		this.dato = dato;
	}


	public NodeClient getNext() {
		return next;
	}


	public void setNext(NodeClient next) {
		this.next = next;
	}

}
