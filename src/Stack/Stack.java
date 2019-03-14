package Stack;

import Node.iNode;

public class Stack<T> implements IStack<iNode<T>> {

	private iNode<T> first;
	private int tam;



	public  Stack(){
		first = null;
		tam=0;
	}
	

	@Override
	public iNode<T> pop() {
		if(first==null){
			return null;
		}
		iNode<T> ax = first;
		first = first.getNext();
		tam--;

		return ax;
	}

	@Override
	public iNode<T> search(iNode<T> text) {
		iNode<T> p = null;
		if(first.getData()==text) {
			p=first;
		}
		else {
			while(first.getNext()!=null) {
			first=first.getNext();
			if(first.getData()==text) {
				p=first;
			}
			}
		}

		return p;
	}

	@Override
	public boolean isEmpty() {
		boolean empty = false;
		if(first==null) {
			empty=true;
		}
		return empty;
}

	@Override
	public iNode<T> getFirts() {
		return first;
	}

	public void setPrimero(iNode<T> primero) {
		this.first = primero;
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
			tam--;
		}
		return e;
	}


	@Override
	public void push(iNode<T> element) {
		iNode<T> n = element;
		if(isEmpty()) {
			first=n;
		}
		else {
			n.setNext(first);
			first=n;
		}
		tam++;
	}

}
