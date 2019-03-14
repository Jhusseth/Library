package Node;

public interface iNode<T> {
	
	iNode<T> getNext();
	iNode<T> getBefore();
	
	void setNext(iNode<T> node);
	void setBefore(iNode<T> node);
	
	boolean haveNext();
	boolean haveBefore();
	boolean checkData();
	
	T getData();
	
}
