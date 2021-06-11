package sample;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.mysql.cj.x.protobuf.MysqlxCrud;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javax.swing.*;

public class WorkersController{

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    @FXML
    private Button get_button_2;

    @FXML
    private Button back_button_1;
    @FXML
    private TextField Name_Firm;

    @FXML
    private TextField Activ;

    @FXML
    private TextField Number;

    @FXML
    private TextField Addr;



    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    void back_action_1(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("FXML/Menu.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }



    @FXML
    void initialize() {
        assert Name_Firm != null : "fx:id=\"Name_Firm\" was not injected: check your FXML file 'Workers.fxml'.";
        assert Activ != null : "fx:id=\"Activ\" was not injected: check your FXML file 'Workers.fxml'.";
        assert Number != null : "fx:id=\"Number\" was not injected: check your FXML file 'Workers.fxml'.";
        assert Addr != null : "fx:id=\"Addr\" was not injected: check your FXML file 'Workers.fxml'.";
        assert get_button_2 != null : "fx:id=\"get_button_2\" was not injected: check your FXML file 'Workers.fxml'.";
        assert back_button_1 != null : "fx:id=\"back_button_1\" was not injected: check your FXML file 'Workers.fxml'.";

    }


    public void get_action(ActionEvent actionEvent) {
    DataBaseHandler dbHandler = new DataBaseHandler();
        dbHandler.SignUpUser(Name_Firm.getText(),Activ.getText(),Addr.getText(),Number.getText());
    }


}
