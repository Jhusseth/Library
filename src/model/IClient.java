package model;

public interface IClient<T> {
	
	public int longitude();
	public boolean isEmpty();
	public void enQueue(T o,long priority);
	public T deQueue();
    public T getFirst();
    public T search(T o);
    public boolean remove(T o);
	
}