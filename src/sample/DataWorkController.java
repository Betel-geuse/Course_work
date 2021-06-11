package sample;

import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import javax.swing.*;

public class DataWorkController {

    @FXML
    private ResourceBundle resources;
    @FXML
    private TextField txt_id2;
    @FXML
    private URL location;
    @FXML
    private TableView<DislpayWorkers> table_user2;
    @FXML
    private TableColumn<DislpayWorkers, Integer> id_col2;

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
    int index1 = -1;
    ObservableList<DislpayWorkers> listN;
    ResultSet rs = null;
    PreparedStatement pst = null;
    ObservableList<DislpayWorkers> Datalist;

    @FXML
    void initialize() throws SQLException, ClassNotFoundException {
        assert back_button_1 != null : "fx:id=\"back_button_4\" was not injected: check your FXML file 'DataWork.fxml'.";
        //DataBaseHandler  dbHanlder3 = new DataBaseHandler();
        id_col2.setCellValueFactory(new PropertyValueFactory<DislpayWorkers, Integer>("id"));
        name_col2.setCellValueFactory(new PropertyValueFactory<DislpayWorkers, String>("name"));
        qualification_col2.setCellValueFactory(new PropertyValueFactory<DislpayWorkers, String>("qualification"));
        speciality_col2.setCellValueFactory(new PropertyValueFactory<DislpayWorkers, String>("speciality"));
        salary_col2.setCellValueFactory(new PropertyValueFactory<DislpayWorkers, String>("salary"));
        phone_col2.setCellValueFactory(new PropertyValueFactory<DislpayWorkers, String>("phone_number"));
        try {
            listN = DataBaseHandler.getDatausers2();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        table_user2.setItems(listN);
        Search2();
    }

    @FXML
    private Button delete_buuton2;

    @FXML
    void Delete_job(ActionEvent event) throws SQLException, ClassNotFoundException {
        Connection dbConnection26 = new DataBaseHandler().getDbConnection();
        String sql2 = "DELETE FROM workers WHERE id =?";
        pst = dbConnection26.prepareStatement(sql2);
        pst.setString(1, txt_id2.getText());
        pst.execute();
        JOptionPane.showMessageDialog(null, "Delete");
    }


    public void GetSelect2(javafx.scene.input.MouseEvent mouseEvent) {
        index1 = table_user2.getSelectionModel().getSelectedIndex();
        txt_id2.setText(id_col2.getCellData(index1).toString());
    }

    void Search2() throws SQLException, ClassNotFoundException {
        id_col2.setCellValueFactory(new PropertyValueFactory<DislpayWorkers, Integer>("id"));
        name_col2.setCellValueFactory(new PropertyValueFactory<DislpayWorkers, String>("name"));
        qualification_col2.setCellValueFactory(new PropertyValueFactory<DislpayWorkers, String>("qualification"));
        speciality_col2.setCellValueFactory(new PropertyValueFactory<DislpayWorkers, String>("speciality"));
        salary_col2.setCellValueFactory(new PropertyValueFactory<DislpayWorkers, String>("salary"));
        phone_col2.setCellValueFactory(new PropertyValueFactory<DislpayWorkers, String>("phone_number"));

        Datalist = DataBaseHandler.getDatausers2();
        table_user2.setItems(Datalist);
        FilteredList<DislpayWorkers> filteredData = new FilteredList<>(Datalist, b -> true);

        txt_id2.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(person -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();
                if (person.getName().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true;
                } else if (person.getQualification().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true;
                } else if (person.getSalary().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true;
                } else if (person.getSpeciality().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true;
                } else if (person.getPhone_number().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true;
                } else
                    return false;
            });
        });
        SortedList<DislpayWorkers> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(table_user2.comparatorProperty());
        table_user2.setItems(sortedData);
    }
}