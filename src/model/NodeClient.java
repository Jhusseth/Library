package model;

public class NodeClient<T> {
	
	private T dato;
	private long priority;
	private NodeClient next;
	

	public NodeClient(T  dato,long priority) {
		this.dato=dato;
		this.priority=priority;
		next=null;
	}


	public T getDato() {
		return dato;
	}


	public void setDato(T dato) {
		this.dato = dato;
	}
	
	public long getPriority() {
		return priority;
	}

	public void setPriority(long priority) {
		this.priority = priority;
	}


	public NodeClient getNext() {
		return next;
	}


	public void setNext(NodeClient next) {
		this.next = next;
	}

}
