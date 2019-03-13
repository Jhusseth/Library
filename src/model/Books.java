package model;

public class Books implements IBook<NodeBooks> {

	private NodeBooks firts;
	private int tam;
	private String name;
	private double value;

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public double getValue() {
		return value;
	}


	public void setValue(double value) {
		this.value = value;
	}


	public Books(String name, double value){
		setPrimero(null);
		tam=0;
		this.name = name;
		this.value= value;
	}
	
	
	@Override
	public void push(NodeBooks element) {
		NodeBooks n = element;
		if(isEmpty()) {
			firts=n;
		}
		else {
			n.setSiguiente(firts);
			firts=n;
		}
		

		tam++;
	}

	@Override
	public NodeBooks pop() {
		if(firts==null){
			return null;
		}
		NodeBooks ax = firts;
		firts = firts.getSiguiente();
		tam--;

		return ax;
	}

	@Override
	public NodeBooks search(NodeBooks text) {
		NodeBooks p = null;
		if(firts.getElemnto()==text) {
			p=firts;
		}
		else {
			while(firts.getSiguiente()!=null) {
			firts=firts.getSiguiente();
			if(firts.getElemnto()==text) {
				p=firts;
			}
			}
		}

		return p;
	}

	@Override
	public boolean isEmpty() {
		boolean empty = false;
		if(firts==null) {
			empty=true;
		}
		return empty;
}

	@Override
	public NodeBooks getFirts() {
		return firts;
	}

	public void setPrimero(NodeBooks primero) {
		this.firts = primero;
	}
	
	@Override
	public int longitude() {
		
		int cant =0;
		for(int i=0;i<tam;i++) {
			cant++;
		}

		return cant;
		
	}
	
	@Override
	public boolean remove(NodeBooks o) {
		boolean e =false;
		NodeBooks p = null;
		if(firts.getElemnto()==o) {
			p=firts;
		}
		else {
			while(firts.getSiguiente()!=null) {
			firts=firts.getSiguiente();
			if(firts.getElemnto()==o) {
				p=firts;
			}
			}
			tam--;
		}
		return e;
	}

}
