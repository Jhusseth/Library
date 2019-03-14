package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

import HashTable.HashTable;

public class Library {

	public void readFile(File file) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new FileReader(file));
		int numberTest = Integer.parseInt(br.readLine());

		for (int i = 0; i < numberTest; i++) {
			int numberRecorderAvailable = Integer.parseInt(br.readLine());
			int numberStands = Integer.parseInt(br.readLine());

			for (int p = 0; p < numberStands ; p++) {
				String standName = br.readLine();
				// The first element is the Name of stand and second the numbers of books of this stand
				String[] standOne = standName.split(" ");
				for (int j = 0; j <= Integer.parseInt(standOne[1]); j++) {
					// The first element is the ISBN, the second is the cost and the third is the amount of books availables
					int[] dataInInt = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
				}
			}
			
			int numOfClients = Integer.parseInt(br.readLine());
			for(int j = 0; i < numOfClients;i++) {
				//The first element in the array is the id of the client
				//The next clientData.length-1 elements are theISNB of the book that the client buy
				int[] clientData = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			}
			
		}
	}
	
	public void solve(){
		try{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			int cases = Integer.parseInt(br.readLine());
			
			for(int i =0;i<cases;i++){
				int cashier = Integer.parseInt(br.readLine());
				int stands = Integer.parseInt(br.readLine());
				for(int j =0;i<stands;j++){	
					String[] hashT = br.readLine().split(" ");		
					char id = hashT[0].charAt(0);	
					int size = Integer.parseInt(hashT[1]);
					
					
					for(int k =0;k<size;k++){			
						String[] books = br.readLine().split(" ");			
						int ISBN = Integer.parseInt(books[0]);		
						int value = Integer.parseInt(books[1]);		
						int cant = Integer.parseInt(books[2]);	
					}
				}
				int cClient = Integer.parseInt(br.readLine());
				for(int z =0;z<cClient;z++){	
					String[] client = br.readLine().split(" ");	
					int code = 	Integer.parseInt(client[0]);	
					for(int x =1;x<client.length;x++){		
						int isbn = Integer.parseInt(client[i]);	
					}
				}
			}
			br.close();
			bw.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

}
