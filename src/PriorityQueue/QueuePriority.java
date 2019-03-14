package PriorityQueue;

import Node.Node;

public class QueuePriority<T> implements IPriority_Queue<Node<T>> {

	private Node<T> queue;
	private int size;
	private int priority;
	
	public QueuePriority() {
		queue = null;
		size=0;
		this.priority=0;
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
	public void enQueue(Node<T> o, long priority) {
		Node<T> newC = null;
		
		newC = queue;
		if(queue==null){
			newC = queue;
		}
		while((newC!=null)){
			if(getPriority()<priority){
				newC.setNext(queue);
				queue = newC;
			}
			else{
				queue =(Node<T>) queue.getNext();
			}
		}
		size++;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	@Override
	public Node<T> deQueue() {
		if(queue == null){
			return null;
		}
		Node<T> ax = queue;
		queue = (Node<T>) queue.getNext();
		size--;
		return ax;
	}

	@Override
	public Node<T> getFirst() {
		return queue;
	}

	@Override
	public Node<T> search(Node<T> o) {
		Node<T> p = null;
		if(queue.getData()==o) {
			p=queue;
		}
		else {
			while(queue.getNext()!=null) {
				queue=(Node<T>) queue.getNext();
			if(queue.getData()==o) {
				p=queue;
			}
			}
		}

		return p;
	}

	public void setFirst(Node<T> first) {
		this.queue = first;
	}


	@Override
	public boolean remove(Node<T> o) {
		boolean e =false;
		Node<T> p = null;
		if(queue.getData()==o) {
			p=queue;
		}
		else {
			while(queue.getNext()!=null) {
				queue=(Node<T>) queue.getNext();
			if(queue.getData()==o) {
				p=queue;
			}
			}
			size--;
		}
		return e;
}
}
