package QueueP;

import java.util.Collection;

import Node.Node;
import Node.iNode;

public class QueueP<T> implements iQueueP<T> {

	private int size;
	private iNode<T> back;
	private iNode<T> front;

	public QueueP(T data) {
		size = 0;
		back = null;
		front = null;
	}

	public QueueP(T[] elements) throws QueueEmptyException{
		for(T element : elements){
			offer(element);
		}
	}

	public QueueP(Collection<T> elements) throws QueueEmptyException{
		for(T element : elements){
			offer(element);
		}
	}

	@Override
	public int getLong() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return front == null;
	}

	@Override
	public T peek() {
		T data = null;
		if (front != null) {
			data = front.getData();
		}
		return data;
	}

	@Override
	public T poll() {
		T data;
		if (front == null){
			data = null;
		}else {
			data = front.getData();
			front = front.getBefore();
			size--;
		}

		if (front == null){
			back = null;
		}
		return data;

	}

	@Override
	public T remove() throws QueueEmptyException {
		T data;
		try {
			if (front == null){
				throw new QueueEmptyException("The queue is empty");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		data = front.getData();
		front = front.getBefore();

		if (front == null){
			back = null;
		}
		size--;
		return data;

	}
	@Override
	public void offer(T element) throws QueueEmptyException{
		if(element == null) {
			throw new NullPointerException();
		}
		if (front == null){
			front = new Node<>(element);
			back = front;
		}else{
			iNode<T> temp = new Node<>(element);
			back.setBefore(temp);
			temp.setNext(back);
			back = temp;
		}
		size++;
	}




}
