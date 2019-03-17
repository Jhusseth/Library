package controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;
import model.Library;
import structures.QueueEmptyException;
import structures.StackEmptyException;

public class controllerLibraryMain implements Initializable {
	private Library library;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	
	public void chooseFile(ActionEvent e) throws QueueEmptyException, StackEmptyException, IOException {
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Open Resource File");
		File f = fileChooser.showOpenDialog(((Node) e.getSource()).getScene().getWindow());
		library = Library.getInstance();
		library.loadTestCase(f);
		launcStandview((Stage) ((Node)e.getSource()).getScene().getWindow());
	}

	private void launcStandview(Stage window) {
		try {
			System.out.println(getClass().getResource("libraryCaliMain.fxml"));
			Parent root = FXMLLoader.load(getClass().getResource("/application/shelvings.fxml"));
			Scene scene = new Scene(root,600,514);
			window.setScene(scene);
			window.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	//getClass().getResource("shelvings.fxml")

}
