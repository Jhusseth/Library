package model;

public class Book {
	
	private int value;
	private int cant;
	private int isbn;

	public Book(int isbn) {
		this.value =0;
		this.cant=0;
		this.isbn = isbn;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	
	public int getCant() {
		return cant;
	}

	public void setCant(int cant) {
		this.cant = cant;
	}

}
