package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.stage.FileChooser;
import javafx.stage.Window;
import model.Library;

public class controllerLibraryMain implements Initializable {
	private Library library;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	
	public void chooseFile(ActionEvent e) {
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Open Resource File");
		File f = fileChooser.showOpenDialog(((Node) e.getSource()).getScene().getWindow());
		
	}
	
	
}
