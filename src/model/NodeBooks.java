package model;

public class NodeBooks {

	private NodeBooks siguiente;
	private int elemento;
	
	public NodeBooks(int e){
		siguiente =null;
		elemento=e;
	}
	
	public NodeBooks getSiguiente() {
		return siguiente;
	}
	public void setSiguiente(NodeBooks siguiente) {
		this.siguiente = siguiente;
	}
	public int getElemnto() {
		return elemento;
	}
	public void setElemnto(int elemento) {
		this.elemento = elemento;
	}
	
	
	
}
