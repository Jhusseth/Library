package application;

import java.io.IOException;

import javax.swing.JFileChooser;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.stage.Stage;
import model.Library;
import structures.QueueEmptyException;
import structures.StackEmptyException;

public class Main extends Application {
	private static Library lb;
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
	
	 public static void main(String ...args) throws IOException, QueueEmptyException, StackEmptyException {
	        JFileChooser j = new JFileChooser();
	        j.showOpenDialog(null);
	        new Library().loadTestCase(j.getSelectedFile());
	    }

}
