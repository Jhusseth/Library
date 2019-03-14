package model;

import Stack.Stack;

public class Client {
	
	private int idClient;
	private Stack<Integer> stackBooks;
	
	public Client(int idClient) {
		this.idClient = idClient;
		this.stackBooks = new Stack<Integer>();
	}

	public int getIdClient() {
		return idClient;
	}

	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}

	public Stack<Integer> getStacBooks() {
		return stackBooks;
	}

	public void setStacBooks(Stack<Integer> stacBooks) {
		this.stackBooks = stacBooks;
	}

}
