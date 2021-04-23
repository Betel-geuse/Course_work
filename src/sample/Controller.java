package sample;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button work_button;

    @FXML
    private Button jobs_button;

    @FXML
    private Button connect_button;

    @FXML
    void initialize() {
        work_button.setOnAction(event-> {
            System.out.println("Hey");
        });
    }
}
