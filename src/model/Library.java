package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

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

}
