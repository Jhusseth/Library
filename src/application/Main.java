package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("libraryCaliMain.fxml"));
			Scene scene = new Scene(root,600,514);
			primaryStage.setScene(scene);
			primaryStage.setTitle("                                                                    ===== Library_Cali =====");
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		//launch(args);
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
