package sample;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MenuController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button workButton;

    @FXML
    private Button connect_button;

    @FXML
    private Button jobs_button;

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private Button data_button1;

    @FXML
    private Button data_button2;

    @FXML
    void Jobs_action(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("FXML/Workers.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML

    void Work_Action(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("FXML/Vacation.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();


    }
    @FXML
    void DataJobs_action(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("FXML/DataWork.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    void DataWork_action(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("FXML/DataJobs.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void initialize() {
        assert workButton != null : "fx:id=\"workButton\" was not injected: check your FXML file 'Menu.fxml'.";
        assert jobs_button != null : "fx:id=\"jobs_button\" was not injected: check your FXML file 'Menu.fxml'.";
        assert data_button1 != null : "fx:id=\"data_button1\" was not injected: check your FXML file 'Menu.fxml'.";
        assert data_button2 != null : "fx:id=\"data_button2\" was not injected: check your FXML file 'Menu.fxml'.";

    }
}