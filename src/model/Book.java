package model;

public class Book {

    private int ISBN;
    private int price;

    public Book(int ISBN, int price){
        this.ISBN = ISBN;
        this.price = price;
    }

    public int getISBN() {
        return ISBN;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return String.valueOf(ISBN);
    }
}
