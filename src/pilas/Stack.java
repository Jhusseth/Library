package pilas;

public class Stack implements IStack<Node> {

	private Node primero;
	private int tam;

	public Stack(){
		setPrimero(null);
		tam=0;
	}
	
	
	@Override
	public void apilar(Node element) {
		Node n = element;
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
	public Node desapilar() {
		if(primero==null){
			return null;
		}
		Node ax = primero;
		primero = primero.getSiguiente();
		tam--;

		return ax;
	}

	@Override
	public Node buscar(int text) {
		Node p = null;
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
	public Node getPrimero() {
		return primero;
	}

	public void setPrimero(Node primero) {
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
		Node p = null;
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
