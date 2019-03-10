package pilas;

public class Node {

	private Node siguiente;
	private int elemento;
	
	public Node(int e){
		siguiente =null;
		elemento=e;
	}
	
	public Node getSiguiente() {
		return siguiente;
	}
	public void setSiguiente(Node siguiente) {
		this.siguiente = siguiente;
	}
	public int getElemnto() {
		return elemento;
	}
	public void setElemnto(int elemento) {
		this.elemento = elemento;
	}
	
	
	
}
