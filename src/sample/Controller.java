package sample;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Controller {

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

    @FXML
    void Work_Action(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("app.fxml"));

        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root1));
        stage.show();

        }


    @FXML
    void initialize() {
        assert workButton != null : "fx:id=\"workButton\" was not injected: check your FXML file 'sample.fxml'.";
        assert connect_button != null : "fx:id=\"connect_button\" was not injected: check your FXML file 'sample.fxml'.";
        assert jobs_button != null : "fx:id=\"jobs_button\" was not injected: check your FXML file 'sample.fxml'.";

    }
}
