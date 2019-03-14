package model;

import Stack.Stack;

public class Client {
	
	private int idClient;
	private Stack<ISBN> stackBooks;
	
	public Client(int idClient) {
		this.idClient = idClient;
		this.stackBooks = new Stack<ISBN>();
	}

	public int getIdClient() {
		return idClient;
	}

	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}

	public Stack<ISBN> getStackBooks() {
		return stackBooks;
	}

	public void setStacBooks(Stack<ISBN> stacBooks) {
		this.stackBooks = stacBooks;
	}
}
