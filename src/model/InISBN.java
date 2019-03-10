package model;

public interface InISBN<V,E> {
	
	boolean isEmpty();
	void add(E element);
	void insertPerReference(V ref, E element);
	void insertPerPosicion(int ref, E element);
	E getValue(int refer)throws Exception;
	boolean search(V referen);
	void remove(V reference);
	

}
