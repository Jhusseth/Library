package model;

public class Book {
	
	private int value;
	private int cant;

	public Book(int value,int cant) {
		this.value = value;
		this.cant=cant;
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
