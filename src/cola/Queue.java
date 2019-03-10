package cola;

public class Queue implements IQueue<Node>{
	
	private Node first;
	private Node end;
	private int size;
	
	public Queue() {

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
	public void enQueue(Node o) {
		Node n= o;
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
	public Node deQueue() {
		if(first ==null){
			return null;
		}
		Node ax = first;
		first = first.getNext();
		size--;
		return ax;
	}

	@Override
	public Node getFirst() {
		return first;
	}

	@Override
	public Node getEnd() {
		return end;
	}

	@Override
	public Node search(int o) {
		Node p = null;
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

	public void setFirst(Node first) {
		this.first = first;
	}

	public void setEnd(Node end) {
		this.end = end;
	}

	@Override
	public boolean remove(int o) {
		boolean e =false;
		Node p = null;
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
