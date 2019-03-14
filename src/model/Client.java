package model;

import Node.Node;
import Stack.Stack;

public class Client implements Comparable<Client> {
	
	private int idClient;
	private Stack<Book> stackBooks;
	
	public Client(int idClient) {
		this.idClient = idClient;
		this.stackBooks = new Stack<Book>();
	}

	public int getIdClient() {
		return idClient;
	}

	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}

	public Stack<Book> getStackBooks() {
		return stackBooks;
	}

	public void setStacBooks(Stack<Book> stacBooks) {
		this.stackBooks = stacBooks;
	}
	
	public void shop (Book b){
		Node<Book> n = new Node<Book>(b);
		stackBooks.push(n);
	}

	@Override
	public int compareTo(Client o) {
		return stackBooks.longitude()-o.getStackBooks().longitude();
	}
}
