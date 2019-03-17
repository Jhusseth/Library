package model;


import structures.QueueEmptyException;
import structures.QueueP;
import structures.StackEmptyException;

public class Recorder {

    private Client client;
    private QueueP<Book> temp;
    private int price;

    public Recorder(){
        temp = new QueueP<>();
        client = new Client(0,0);
    }

    public void executeAction() throws QueueEmptyException, StackEmptyException{
        Book b = client.retireOfHamper();
        price += b.getPrice();
        temp.offer(b);
    }

    public boolean hasNext(){
        if (!client.end()){
            this.client.setPurchased(temp);
            this.client.setSoldValue(price);
        }
        return !client.end();
    }

    public void setClient(Client client) {
        price = 0;
        temp = new QueueP<>();
        this.client = client;
    }
}

