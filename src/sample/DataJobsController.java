package sample;

import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class DataJobsController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<jobs> table_user;
    @FXML
    private TableColumn<jobs, Integer> id_col;

    @FXML
    private TableColumn<jobs, String> firm_col;

    @FXML
    private TableColumn<jobs, String> activity_col;

    @FXML
    private TableColumn<jobs, String> addres_col;

    @FXML
    private TableColumn<jobs, String> phone_col;

    @FXML
    private Button back_button_5;
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    void back_action_5(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("FXML/Menu.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    int index = 1;
    ObservableList<jobs> listM;
    ResultSet rs = null;
    PreparedStatement pst = null;

    @FXML
    void initialize() {
        DataBaseHandler  dbHanlder3 = new DataBaseHandler();
        assert back_button_5 != null : "fx:id=\"back_button_5\" was not injected: check your FXML file 'DataJobs.fxml'.";
        id_col.setCellValueFactory(new PropertyValueFactory<jobs,Integer>("id"));
        firm_col.setCellValueFactory(new PropertyValueFactory<jobs,String>("name_firm"));
        activity_col.setCellValueFactory(new PropertyValueFactory<jobs,String>("activity"));
        addres_col.setCellValueFactory(new PropertyValueFactory<jobs, String>("addres"));
        phone_col.setCellValueFactory(new PropertyValueFactory<jobs,String>("phoneNumber"));
        try {
            listM = DataBaseHandler.getDatausers();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        table_user.setItems(listM);
    }

}
