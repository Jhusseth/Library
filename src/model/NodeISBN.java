package model;

public class NodeISBN<E> {
	
    private E value;

    private NodeISBN<E> next;

    public NodeISBN(){
        this.value = null;
        this.next = null;
    }
    
    public E getValor() {
        return value;
    }

    public void setValor(E valor) {
        this.value = valor;
    }

    public NodeISBN<E> getSiguiente() {
        return next;
    }

    public void setSiguiente(NodeISBN<E> next) {
        this.next = next;
    }   
}