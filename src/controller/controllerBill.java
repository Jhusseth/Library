package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class controllerBill implements Initializable {
	
	@FXML
	private TextArea textArea;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	
	public void again(ActionEvent e) throws IOException {
		Stage primaryStage = (Stage) ((Node) e.getSource()).getScene().getWindow();
		Parent root = FXMLLoader.load(getClass().getResource("libraryCaliMain.fxml"));
		Scene scene = new Scene(root,600,514);
		primaryStage.setScene(scene);
	}
	
	public void printOut() {
		
		
	}

}
