package model;

public class Books implements IBook<NodeBooks> {

	private NodeBooks primero;
	private int tam;

	public Books(){
		setPrimero(null);
		tam=0;
	}
	
	
	@Override
	public void apilar(NodeBooks element) {
		NodeBooks n = element;
		if(estaVacia()) {
			primero=n;
		}
		else {
			n.setSiguiente(primero);
			primero=n;
		}
		

		tam++;
	}

	@Override
	public NodeBooks desapilar() {
		if(primero==null){
			return null;
		}
		NodeBooks ax = primero;
		primero = primero.getSiguiente();
		tam--;

		return ax;
	}

	@Override
	public NodeBooks buscar(int text) {
		NodeBooks p = null;
		if(primero.getElemnto()==text) {
			p=primero;
		}
		else {
			while(primero.getSiguiente()!=null) {
			primero=primero.getSiguiente();
			if(primero.getElemnto()==text) {
				p=primero;
			}
			}
		}

		return p;
	}

	@Override
	public boolean estaVacia() {
		boolean empty = false;
		if(primero==null) {
			empty=true;
		}
		return empty;
}

	@Override
	public NodeBooks getPrimero() {
		return primero;
	}

	public void setPrimero(NodeBooks primero) {
		this.primero = primero;
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
		if(primero.getElemnto()==o) {
			p=primero;
		}
		else {
			while(primero.getSiguiente()!=null) {
			primero=primero.getSiguiente();
			if(primero.getElemnto()==o) {
				p=primero;
			}
			}
			tam--;
		}
		return e;
	}

}
