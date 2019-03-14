package Queue;

import node.iNode;

public class Queue<T> implements IQueue<iNode<T>>{
	
	private iNode<T> first;
	private iNode<T> end;
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
	public void enQueue(iNode<T> o) {
		iNode<T> n= o;
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
	public iNode<T> deQueue() {
		if(first ==null){
			return null;
		}
		iNode<T> ax = first;
		first = first.getNext();
		size--;
		return ax;
	}

	@Override
	public iNode<T> getFirst() {
		return first;
	}

	@Override
	public iNode<T> getEnd() {
		return end;
	}

	@Override
	public iNode<T> search(iNode<T> o) {
		iNode<T> p = null;
		if(first.getData()==o) {
			p=first;
		}
		else {
			while(first.getNext()!=null) {
				first=first.getNext();
			if(first.getData()==o) {
				p=first;
			}
			}
		}

		return p;
	}

	public void setFirst(iNode<T> first) {
		this.first = first;
	}

	public void setEnd(iNode<T> end) {
		this.end = end;
	}

	@Override
	public boolean remove(iNode<T> o) {
		boolean e =false;
		iNode<T> p = null;
		if(first.getData()==o) {
			p=first;
		}
		else {
			while(first.getNext()!=null) {
				first=first.getNext();
			if(first.getData()==o) {
				p=first;
			}
			}
			size--;
		}
		return e;
}
}
