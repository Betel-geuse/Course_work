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
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class VacationController {
    @FXML
    private URL location;

    @FXML
    private TextField Name_w;

    @FXML
    private TextField qualification_w;

    @FXML
    private TextField salary_w;

    @FXML
    private TextField speciality_w;

    @FXML
    private TextField phone_w;

    @FXML
    private ResourceBundle resources;



    @FXML
    private Button get_button;

    @FXML
    private Button back_button_2;

    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    void back_action_2(ActionEvent event)throws IOException {
        root = FXMLLoader.load(getClass().getResource("FXML/Menu.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();


    }

    @FXML
    void get_action_2(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert get_button != null : "fx:id=\"get_button\" was not injected: check your FXML file 'Vacation.fxml'.";
        assert back_button_2 != null : "fx:id=\"back_button_2\" was not injected: check your FXML file 'Vacation.fxml'.";

    }

    @FXML
    DataBaseHandler dbHandler2 = new DataBaseHandler();
   public void to_datawork(ActionEvent event) {
        dbHandler2.SignUpWork(Name_w.getText(),qualification_w.getText(),speciality_w.getText(),salary_w.getText(),phone_w.getText());
    }
}
