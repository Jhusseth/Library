package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import model.Library;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ShelvingsController implements Initializable {

    @FXML
    private TextArea area;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            area.setText(Library.getInstance().launchStands());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void launchClients(ActionEvent e){
        Stage window = (Stage) ((Node) e.getSource()).getScene().getWindow();
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/application/CBE.fxml"));
            Scene scene = new Scene(root,600,514);
            window.setScene(scene);
            window.show();
        } catch(Exception e1) {
            e1.printStackTrace();
        }
    }


}
