package StackP;
import java.util.Collection;

import Node.Node;
import Node.iNode;

public class StackP<T> implements iStackP<T> {

    /**
     * tamaño de la pila
     */
    private int tamnho;

    /**
     * Nodo que representa la cima de la pila
     */
    private iNode<T> cima;

    /**
     * Crea una nueva pila vacia
     */
    public StackP(){
        tamnho = 0;
        cima = null;
    }

    /**
     * Crea una pila con los elementos que le llegan por parametro, estos se iran agregando en el orden en que se introucen
     * @param elementos
     */
    public StackP(T ...elementos){
        if (elementos == null){
            throw new NullPointerException();
        }
        for (T e: elementos) {
            push(e);
        }
    }

    /**
     * Crea una pila con los elementos que le llegan por parametro, estos se iran agregando en el orden en que se introucen
     * @param elementos
     */
    public StackP(Collection<T> elementos){
        if (elementos == null){
            throw new NullPointerException();
        }
        for(T e: elementos){
            push(e);
        }
    }

    /**
     * Inserta un nuevo elemento en la cima de la pila, el elemento no puede ser nulo
     *
     * @param element
     */
    @Override
    public void push(T element) {
        if (element == null){
            throw new NullPointerException();
        }
        if (cima == null){
            cima = new Node<T>(element);
        }else{
            Node<T> temp = new Node<>(element);
            temp.setNext(cima);
            cima = temp;
        }
        tamnho++;
    }

    /**
     * Retorna el elemento de la cima sin modificar la pila
     *
     * @return
     */
    @Override
    public T peek() throws StackEmptyException {
        if(cima == null){
            throw new StackEmptyException("La pila esta vacia");
        }
        return cima.getData();
    }

    /**
     * Retorna el elemento de la cima y lo elimina de la cima
     *
     * @return
     */
    @Override
    public T pop() throws StackEmptyException {
        if(cima == null) {
            throw new StackEmptyException("La pila esta vacia");
        }
        T dato = cima.getData();
        cima = cima.getNext();
        tamnho--;
        return dato;
    }

    /**
     * Retorna la cantidad de elemento disponibles en la pila
     *
     * @return
     */
    @Override
    public int tamanho() {
        return tamnho;
    }

    /**
     * Retorna si la pila esta vacia o no
     *
     * @return
     */
    @Override
    public boolean empty() {
        return cima == null;
    }

}