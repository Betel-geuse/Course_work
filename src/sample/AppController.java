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

public class AppController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button back_button_2;
    
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    void back_action_2(ActionEvent event)throws IOException {
            root = FXMLLoader.load(getClass().getResource("sample.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
    }

    @FXML
    void initialize() {
        assert back_button_2 != null : "fx:id=\"back_button_2\" was not injected: check your FXML file 'app.fxml'.";

    }
}
