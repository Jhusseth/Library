package application;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.stage.Stage;
import structures.QueueEmptyException;
import structures.StackEmptyException;

public class Main extends Application {

	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("libraryCaliMain.fxml"));
			Scene scene = new Scene(root,600,514);
			primaryStage.setScene(scene);
			primaryStage.setTitle("===== Library_Cali =====");
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	 public static void main(String ...args) throws IOException, QueueEmptyException, StackEmptyException {
	        launch(args);
	    }

}
