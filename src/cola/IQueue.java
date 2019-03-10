package cola;

public interface IQueue<T> {
	
	public int longitude();
	public boolean isEmpty();
	public void enQueue(T o);
	public T deQueue();
    public T getFirst();
    public T getEnd();
    public T search(int o);
    public boolean remove(int o);

}