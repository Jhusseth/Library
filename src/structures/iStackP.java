package structures;

public interface iStackP<T> {

   
    void push(T element);

    T pop() throws StackEmptyException;

    T peek() throws StackEmptyException;

    int tamanho();

    boolean empty();

}
