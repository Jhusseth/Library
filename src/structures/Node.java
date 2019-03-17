package structures;

public class Node<T> implements iNode<T> {
	
	private T data;
	private iNode<T> next;
	private iNode<T> before;
	
	public Node(T data) {
		this.data = data;
		next = null;
		before = null;
	}
	
	@Override
	public iNode getNext() {
		return next;
	}
	
	@Override
	public iNode getBefore() {
		return before;
	}

	@Override
	public void setNext(iNode node) {
		next = node;
	}

	@Override
	public void setBefore(iNode node) {
		before = node;
		
	}

	@Override
	public boolean haveNext() {
		return next != null;
	}

	@Override
	public boolean haveBefore() {
		return before != null;
	}

	@Override
	public boolean checkData() {
		
		return data != null;
	}

	@Override
	public T getData() {
		return data;
	}
	
	
	public void setData(T node) {
		data=node;
	}
	
}
