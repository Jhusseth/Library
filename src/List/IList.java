package List;

public interface IList<T> {
	
	boolean isEmpty();
	void add(T element);
	boolean search(T element);
	void remove(T element);
	T getFirst();
	

}
