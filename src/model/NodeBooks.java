package model;

public class NodeBooks<T> {

	private NodeBooks siguiente;
	private  T elemento;
	
	public NodeBooks(T e){
		siguiente =null;
		elemento=e;
	}
	
	public NodeBooks getSiguiente() {
		return siguiente;
	}
	public void setSiguiente(NodeBooks siguiente) {
		this.siguiente = siguiente;
	}
	public T getElemnto() {
		return elemento;
	}
	public void setElemnto(T elemento) {
		this.elemento = elemento;
	}
	
	
	
}
