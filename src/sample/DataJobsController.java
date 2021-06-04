package sample;

import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Locale;
import java.util.ResourceBundle;

import javafx.beans.InvalidationListener;
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

public class DataJobsController  {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    @FXML
    private TextField txt_id;
    @FXML
    private TableView<DisplayJobs> table_user;
    @FXML
    private TableColumn<DisplayJobs, Integer> id_col;

    @FXML
    private TableColumn<DisplayJobs, String> firm_col;

    @FXML
    private TableColumn<DisplayJobs, String> activity_col;

    @FXML
    private TableColumn<DisplayJobs, String> addres_col;

    @FXML
    private TableColumn<DisplayJobs, String> phone_col;

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
    int index = -1;
    ObservableList<DisplayJobs> listM;
    ResultSet rs = null;
    PreparedStatement pst = null;
    ObservableList<DisplayJobs> Datalist;

    @FXML
    void initialize() throws SQLException, ClassNotFoundException {
        DataBaseHandler  dbHanlder3 = new DataBaseHandler();
        assert back_button_5 != null : "fx:id=\"back_button_5\" was not injected: check your FXML file 'DataJobs.fxml'.";
        id_col.setCellValueFactory(new PropertyValueFactory<DisplayJobs,Integer>("id"));
        firm_col.setCellValueFactory(new PropertyValueFactory<DisplayJobs,String>("name_firm"));
        activity_col.setCellValueFactory(new PropertyValueFactory<DisplayJobs,String>("activity"));
        addres_col.setCellValueFactory(new PropertyValueFactory<DisplayJobs, String>("addres"));
        phone_col.setCellValueFactory(new PropertyValueFactory<DisplayJobs,String>("phoneNumber"));
        try {
            listM = DataBaseHandler.getDatausers();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        table_user.setItems(listM);
        assert back_button_5 != null : "fx:id=\"back_button_5\" was not injected: check your FXML file 'DataJobs.fxml'.";
        assert table_user != null : "fx:id=\"table_user\" was not injected: check your FXML file 'DataJobs.fxml'.";
        assert id_col != null : "fx:id=\"id_col\" was not injected: check your FXML file 'DataJobs.fxml'.";
        assert firm_col != null : "fx:id=\"firm_col\" was not injected: check your FXML file 'DataJobs.fxml'.";
        assert activity_col != null : "fx:id=\"activity_col\" was not injected: check your FXML file 'DataJobs.fxml'.";
        assert addres_col != null : "fx:id=\"addres_col\" was not injected: check your FXML file 'DataJobs.fxml'.";
        assert phone_col != null : "fx:id=\"phone_col\" was not injected: check your FXML file 'DataJobs.fxml'.";
        assert delete_buuton != null : "fx:id=\"delete_buuton\" was not injected: check your FXML file 'DataJobs.fxml'.";
        assert txt_id != null : "fx:id=\"txt_id\" was not injected: check your FXML file 'DataJobs.fxml'.";
        Search();
    }

    @FXML
    private Button delete_buuton;

    @FXML
    void Delete_wor(ActionEvent event) throws SQLException, ClassNotFoundException {
        //TableView<DisplayJobs> TableView = new TableView<>();
       //DisplayJobs id =TableView.getSelectionModel().getSelectedItem();
        Connection dbConnection24 = new DataBaseHandler().getDbConnection();
        String sql = "DELETE FROM jobs WHERE id = ?";
        pst = dbConnection24.prepareStatement(sql);
        pst.setString(1, txt_id.getText());
        pst.execute();
        JOptionPane.showMessageDialog(null,"Delete");
    }

    @FXML
    public void GetSelect(javafx.scene.input.MouseEvent mouseEvent) {
        index = table_user.getSelectionModel().getSelectedIndex();
        txt_id.setText(id_col.getCellData(index).toString());
    }
    @FXML
    void Search() throws SQLException, ClassNotFoundException {
        id_col.setCellValueFactory(new PropertyValueFactory<DisplayJobs,Integer>("id"));
        firm_col.setCellValueFactory(new PropertyValueFactory<DisplayJobs,String>("name_firm"));
        activity_col.setCellValueFactory(new PropertyValueFactory<DisplayJobs,String>("activity"));
        addres_col.setCellValueFactory(new PropertyValueFactory<DisplayJobs, String>("addres"));
        phone_col.setCellValueFactory(new PropertyValueFactory<DisplayJobs,String>("phoneNumber"));

        Datalist = DataBaseHandler.getDatausers();
        table_user.setItems(Datalist);
        FilteredList<DisplayJobs> filteredData = new FilteredList<>(Datalist,b->true);

        txt_id.textProperty().addListener((observable,oldValue, newValue)->{filteredData.setPredicate(person->{
            if (newValue == null || newValue.isEmpty()){
                return  true;
            }
            String lowerCaseFilter = newValue.toLowerCase();
            if (person.getActivity().toLowerCase().indexOf(lowerCaseFilter) != -1){
                return  true;
            }
            else if(person.getAddres().toLowerCase().indexOf(lowerCaseFilter) != -1){
                return  true;
            }
            else
                return  false;
        });
    });
        SortedList<DisplayJobs> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(table_user.comparatorProperty());
        table_user.setItems(sortedData);
}
}


