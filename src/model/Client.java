package model;

import Stack.Stack;

public class Client {
	
	private int idClient;
	private Stack<Book> stackBooks;
	
	public Client(int idClient) {
		this.idClient = idClient;
		this.stackBooks = null;
	}

	public int getIdClient() {
		return idClient;
	}

	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}

	public Stack<Book> getStacBooks() {
		return stackBooks;
	}

	public void setStacBooks(Stack<Book> stacBooks) {
		this.stackBooks = stacBooks;
	}

}
