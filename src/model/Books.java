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
	public void apilar(NodeBooks element) {
		NodeBooks n = element;
		if(estaVacia()) {
			firts=n;
		}
		else {
			n.setSiguiente(firts);
			firts=n;
		}
		

		tam++;
	}

	@Override
	public NodeBooks desapilar() {
		if(firts==null){
			return null;
		}
		NodeBooks ax = firts;
		firts = firts.getSiguiente();
		tam--;

		return ax;
	}

	@Override
	public NodeBooks buscar(int text) {
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
	public boolean estaVacia() {
		boolean empty = false;
		if(firts==null) {
			empty=true;
		}
		return empty;
}

	@Override
	public NodeBooks getPrimero() {
		return firts;
	}

	public void setPrimero(NodeBooks primero) {
		this.firts = primero;
	}
	
	@Override
	public int longitud() {
		
		int cant =0;
		for(int i=0;i<tam;i++) {
			cant++;
		}

		return cant;
		
	}
	
	@Override
	public boolean remover(int o) {
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
