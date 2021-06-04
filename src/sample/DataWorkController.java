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

public class DataWorkController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    @FXML
    private TableView<DislpayWorkers> table_user2;
    @FXML
    private TableColumn<DislpayWorkers,Integer> id_col2;

    @FXML
    private TableColumn<DislpayWorkers, String> name_col2;

    @FXML
    private TableColumn<DislpayWorkers, String> qualification_col2;

    @FXML
    private TableColumn<DislpayWorkers, String> speciality_col2;

    @FXML
    private TableColumn<DislpayWorkers, String> salary_col2;

    @FXML
    private TableColumn<DislpayWorkers, String> phone_col2;
    @FXML
    private Button back_button_1;
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    void back_action_4(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("FXML/Menu.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    int index = 1;
    ObservableList<DislpayWorkers> listN;
    ResultSet rs = null;
    PreparedStatement pst = null;

    @FXML
    void initialize() {
        assert back_button_1 != null : "fx:id=\"back_button_4\" was not injected: check your FXML file 'DataWork.fxml'.";
        //DataBaseHandler  dbHanlder3 = new DataBaseHandler();
        id_col2.setCellValueFactory(new PropertyValueFactory<DislpayWorkers,Integer>("id"));
        name_col2.setCellValueFactory(new PropertyValueFactory<DislpayWorkers,String>("name"));
        qualification_col2.setCellValueFactory(new PropertyValueFactory<DislpayWorkers,String>("qualification"));
        speciality_col2.setCellValueFactory(new PropertyValueFactory<DislpayWorkers, String>("speciality"));
        salary_col2.setCellValueFactory(new PropertyValueFactory<DislpayWorkers,String>("salary"));
        phone_col2.setCellValueFactory(new PropertyValueFactory<DislpayWorkers,String>("phone_number"));
        try {
            listN = DataBaseHandler.getDatausers2();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        table_user2.setItems(listN);
    }
}
