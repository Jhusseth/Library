package model;

public class Client implements IClient<NodeClient> {

	private NodeClient cola;
	
	private int size;
	
	public Client() {
		cola = null;
		size=0;
	}

	@Override
	public int longitude() {
		int cant =0;
		for(int i=0;i<size;i++){
			cant++;
		}
		
		return cant;
	}

	@Override
	public boolean isEmpty() {
		boolean b =false;
		if(size==0){
			b=true;
		}
		return b;
	}

	@Override
	public void enQueue(NodeClient o, long priority) {
		NodeClient newC = null;
		
		boolean found =false;
		while((newC!=null)&&!found){
			if(cola.getPriority()<priority){
				found=true;
			}
			else{
				newC=cola.getNext();
			}
		}
	}

	@Override
	public NodeClient deQueue() {
		if(cola == null){
			return null;
		}
		NodeClient ax = cola;
		cola = cola.getNext();
		size--;
		return ax;
	}

	@Override
	public NodeClient getFirst() {
		return cola;
	}

	@Override
	public NodeClient search(NodeClient o) {
		NodeClient p = null;
		if(cola.getDato()==o) {
			p=cola;
		}
		else {
			while(cola.getNext()!=null) {
				cola=cola.getNext();
			if(cola.getDato()==o) {
				p=cola;
			}
			}
		}

		return p;
	}

	public void setFirst(NodeClient first) {
		this.cola = first;
	}


	@Override
	public boolean remove(NodeClient o) {
		boolean e =false;
		NodeClient p = null;
		if(cola.getDato()==o) {
			p=cola;
		}
		else {
			while(cola.getNext()!=null) {
				cola=cola.getNext();
			if(cola.getDato()==o) {
				p=cola;
			}
			}
			size--;
		}
		return e;
}
}
