package model;

public class Client implements IClient<NodeClient> {

	private NodeClient first;
	private NodeClient end;
	private int size;
	
	public Client() {
		first = null;
		end = null;
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
	public void enQueue(NodeClient o) {
		NodeClient n= o;
		if(first==null){
			first =n;
			end=n;
		}
		else{
			end.setNext(n);
			end=n;
		}
	}

	@Override
	public NodeClient deQueue() {
		if(first ==null){
			return null;
		}
		NodeClient ax = first;
		first = first.getNext();
		size--;
		return ax;
	}

	@Override
	public NodeClient getFirst() {
		return first;
	}

	@Override
	public NodeClient getEnd() {
		return end;
	}

	@Override
	public NodeClient search(int o) {
		NodeClient p = null;
		if(first.getDato()==o) {
			p=first;
		}
		else {
			while(first.getNext()!=null) {
				first=first.getNext();
			if(first.getDato()==o) {
				p=first;
			}
			}
		}

		return p;
	}

	public void setFirst(NodeClient first) {
		this.first = first;
	}

	public void setEnd(NodeClient end) {
		this.end = end;
	}

	@Override
	public boolean remove(int o) {
		boolean e =false;
		NodeClient p = null;
		if(first.getDato()==o) {
			p=first;
		}
		else {
			while(first.getNext()!=null) {
				first=first.getNext();
			if(first.getDato()==o) {
				p=first;
			}
			}
			size--;
		}
		return e;
}
}
