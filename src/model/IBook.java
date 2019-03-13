package model;

public interface IBook<T> {

	public void push (T element);
	public T pop();
	public boolean remove(T o);
	public T search(T text);
	public boolean isEmpty();
	public int longitude();
	public T getFirts();
}
