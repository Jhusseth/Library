package model;

public interface IBook<T> {

	public void apilar (T element);
	public T desapilar();
	public boolean remover(int o);
	public T buscar(int text);
	public boolean estaVacia();
	public int longitud();
	public T getPrimero();
}
