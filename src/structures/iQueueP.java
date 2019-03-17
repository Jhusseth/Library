package structures;

public interface iQueueP<T>{
	int getLong();
	boolean isEmpty();
	T peek();
	T poll();
	T remove() throws QueueEmptyException;
	void offer(T element) throws QueueEmptyException;
	
	
}

