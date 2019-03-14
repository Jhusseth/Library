package PriorityQueue;

import node.iNode;

public class QueuePriority<T> implements IPriority_Queue<iNode<T>> {

	private iNode<T> queue;
	private int code;
	private int size;
	private int priority;
	
	public QueuePriority(int code) {
		queue = null;
		size=0;
		this.code = code;
		this.priority=0;
	}
	
	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
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
	public void enQueue(iNode<T> o, long priority) {
		iNode<T> newC = null;
		
		boolean found =false;
		while((newC!=null)&&!found){
			if(getPriority()<priority){
				found=true;
			}
			else{
				newC=queue.getNext();
			}
		}
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	@Override
	public iNode<T> deQueue() {
		if(queue == null){
			return null;
		}
		iNode<T> ax = queue;
		queue = queue.getNext();
		size--;
		return ax;
	}

	@Override
	public iNode<T> getFirst() {
		return queue;
	}

	@Override
	public iNode<T> search(iNode<T> o) {
		iNode<T> p = null;
		if(queue.getData()==o) {
			p=queue;
		}
		else {
			while(queue.getNext()!=null) {
				queue=queue.getNext();
			if(queue.getData()==o) {
				p=queue;
			}
			}
		}

		return p;
	}

	public void setFirst(iNode<T> first) {
		this.queue = first;
	}


	@Override
	public boolean remove(iNode<T> o) {
		boolean e =false;
		iNode<T> p = null;
		if(queue.getData()==o) {
			p=queue;
		}
		else {
			while(queue.getNext()!=null) {
				queue=queue.getNext();
			if(queue.getData()==o) {
				p=queue;
			}
			}
			size--;
		}
		return e;
}
}
