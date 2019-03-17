package model;

import java.util.ArrayList;
import java.util.List;
import structures.QueueP;

import structures.StackEmptyException;
import structures.StackP;

public class Client implements Comparable<Client>{

    private StackP<Book> hamper;
    private List<Integer> ISBNs;
    private int id;
    private int soldBookMount;
    private int pos;
    private int soldValue;
    private QueueP<Book> purchased;

    Client(int id, int pos){
        soldBookMount = 0;
        ISBNs = new ArrayList<>();
        hamper = new StackP<>();
        this.id = id;
        this.pos = pos;
    }

    public int getId(){
        return id;
    }

    public void addBook(Book book){
        hamper.push(book);
        ISBNs.add(book.getISBN());
        soldBookMount++;
    }

    public Book retireOfHamper() throws StackEmptyException{
        ISBNs.remove(0);
        return hamper.pop();
    }

    public boolean end(){
        return hamper.empty();
    }

    public int numOfBooks(){
        return soldBookMount;
    }

    @Override
    public int compareTo(Client client) {
        return (soldBookMount + pos) - (client.soldBookMount + pos);
    }
    
    public String toString() {
    	 String libros = "\n";
    	 int size = purchased.getLong();
    	 if(purchased != null) {
    		 for (int i = 0; i < size; i++) {
				libros += purchased.poll();
			}
    	 }else {
    		for (int i = 0; i < ISBNs.size(); i++) {
				libros += ISBNs.get(i);
			}
    	 }
		return "CLient N."+pos+"("+ id +")"+ (purchased!=null?" "+soldValue:"") +": " + libros;
    	
    	
    }
//    @Override
//    public String toString() {
//        String libros = "\n";
//        for (Object i: purchased != null?purchased:ISBNs) {
//            libros += i + ",";
//        }
//        return "CLient N."+pos+"("+ id +")"+ (purchased!=null?" "+soldValue:"") +": " + libros;
//    }

    public int getSoldValue() {
        return soldValue;
    }

    public void setSoldValue(int soldValue) {
        this.soldValue = soldValue;
    }

    public QueueP<Book> getPurchased() {
        return purchased;
    }

    public void setPurchased(QueueP<Book> purchased) {
        this.purchased = purchased;
    }
}
