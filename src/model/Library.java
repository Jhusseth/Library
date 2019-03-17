package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import structures.HashTable;
import structures.QueueEmptyException;
import structures.StackEmptyException;

public class Library {

    private HashTable<String,Shelving> shelvings;
    private int numberRecorderAvailable;
    private Client[] clients;
    private Recorder[] recoders;
    private BufferedReader br;

    private static Library instance;

    private Library(){
    }

    public static Library getInstance() {
        if (instance == null){
            instance = new Library();
        }
        return instance;
    }

    public void loadTestCase(File file) throws IOException, QueueEmptyException, StackEmptyException {

        br = new BufferedReader(new FileReader(file));
        int numberTest = Integer.parseInt(br.readLine());
        iniciarCajeros();
    }

    public String toPayQueue() {
        String clientsQueue = "";
        Arrays.sort(clients);
        System.out.println("\nClients to Recorders");
        for (Client c: clients) {
            System.out.println(c);
            clientsQueue += c + "\n";
        }
        return clientsQueue;
    }

    public String clientsGetIn() throws IOException {
        System.out.println("Clients:");
        String clientsIn = "";
        int numOfClients = Integer.parseInt(br.readLine());
        clients = new Client[numOfClients];
        for(int j = 0; j < numOfClients;j++) {
            //The first element in the array is the id of the client
            //The next clientData.length-1 elements are theISNB of the book that the client buy
            int[] clientData = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            clients[j] = new Client(clientData[0],j+1);
            for (int k = 1; k < clientData.length; k++) {
                clients[j].addBook(shelvings.get(""+clientData[k]).getBook(clientData[k]));
            }
            System.out.println(clients[j]);
            clientsIn += clients[j] + "\n";
        }
        return clientsIn;
    }

    public String launchStands() throws IOException {
        String Stands = "";
        int numberStands = Integer.parseInt(br.readLine());
        shelvings = new HashTable<>(numberStands*10);

        System.out.println("Shelving before clients:");

        for (int p = 0; p < numberStands ; p++) {
            // The first element is the Name of stand and second the numbers of books of this stand
            String[] shelving = br.readLine().split(" ");
            shelvings.put(shelving[0],new Shelving(shelving[0]));
            for (int j = 0; j < Integer.parseInt(shelving[1]); j++) {
                // The first element is the ISBN, the second is the cost and the third is the amount of books availables
                int[] dataInInt = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                shelvings.get(shelving[0]).addBook(new Book(dataInInt[0],dataInInt[1]),dataInInt[2]);
                shelvings.put(""+dataInInt[0],shelvings.get(shelving[0]));
            }
            System.out.println(shelvings.get(shelving[0]));
            Stands += shelvings.get(shelving[0]) + "\n";
        }
        return Stands;
    }

    public void iniciarCajeros() throws IOException {
        numberRecorderAvailable = Integer.parseInt(br.readLine());
        recoders = new Recorder[numberRecorderAvailable];
        for (int j = 0; j < numberRecorderAvailable; j++) {
            recoders[j] = new Recorder();
        }
    }

    public String recorders() throws QueueEmptyException, StackEmptyException{
        System.out.println("\n Numbre of recorders:" + numberRecorderAvailable);
        String info = "";
        int indx = 0;
        int terminate = 0;
        while (terminate < numberRecorderAvailable * clients.length){
            for (int i = 0; i < numberRecorderAvailable; i++) {
                if (recoders[i].hasNext()){
                    recoders[i].executeAction();
                }else {
                    if (indx < clients.length){
                        recoders[i].setClient(clients[indx]);
                        indx++;
                    }else{
                        terminate += 1;
                    }
                }
            }
        }
        for (Client c: clients) {
            info += c + "\n";
        }
        System.out.println(info);
        return info;
    }

}
