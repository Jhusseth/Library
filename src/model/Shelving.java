package model;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class Shelving {

    private Hashtable<Integer, List<Book>> shelving;
    private String name;

    public Shelving(String name){
        this.name = name;
        shelving = new Hashtable<>();
    }

    public void addBook(Book book,int mount){
        for (int i = 0; i < mount; i++) {
            if (shelving.containsKey(book.getISBN())){
                shelving.get(book.getISBN()).add(book);
            }else{
                shelving.put(book.getISBN(),new ArrayList<>());
                shelving.get(book.getISBN()).add(book);
            }
        }
    }

    public boolean containsBoock(int ISBN){
        return shelving.containsKey(ISBN) && shelving.get(ISBN).size()>0;
    }

    public Book getBook(int ISBN){
        Book b = shelving.get(ISBN).remove(0);
        if(shelving.get(ISBN).isEmpty()) shelving.remove(ISBN);
        return b;
    }

    @Override
    public String toString() {
        String content = "";
        for (int key:shelving.keySet()) {
            content += "---> ISBN:" + key + " :: Precio:$" + shelving.get(key).get(0).getPrice() +
                    " :: Existencias:" + shelving.get(key).size()+"\n";
        }
        return name+":\n" + content;
    }
}

