package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

public class DataBaseHandler extends  Configs {
    Connection dbConnection;
    //Connection conn = null;

    public Connection getDbConnection() throws ClassNotFoundException, SQLException {
        String connectionString = "jdbc:mysql://" + dbHost + ":" + dbPort + "/" + dbName;

        Class.forName("com.mysql.jdbc.Driver");

        dbConnection = DriverManager.getConnection(connectionString, dbUser, dbPass);
        return dbConnection;
    }


    public void SignUpUser(String name_firm, String activity, String addres, String phoneNumber) {
        String insert = "INSERT " + Const.USER_TABLE + "("
                + Const.NAME_FIRM + "," + Const.ACTIVITY + ","
                + Const.ADDRES + "," + Const.PHONE_NUMBER + ")" + "VALUES(?,?,?,?)";


        try {

            PreparedStatement prSt = getDbConnection().prepareStatement(insert);
            prSt.setString(1, name_firm);
            prSt.setString(2, activity);
            prSt.setString(3, addres);
            prSt.setString(4, phoneNumber);
            prSt.executeUpdate();

        } catch (SQLException throwable) {
            throwable.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public void SignUpWork(String name, String qualification, String speciality, String salary, String phone_number) {
        String insert = "INSERT " + Const.USER_TABLE1 + "("
                + Const.NAME + "," + Const.QUALIFICATION + ","
                + Const.SPECIALITY + "," + Const.SALARY + "," + Const.PHONE_FIRM + ")" + "VALUES(?,?,?,?,?)";


        try {

            PreparedStatement prSt2 = getDbConnection().prepareStatement(insert);
            prSt2.setString(1, name);
            prSt2.setString(2, qualification);
            prSt2.setString(3, speciality);
            prSt2.setString(4, salary);
            prSt2.setString(5, phone_number);
            prSt2.executeUpdate();

        } catch (SQLException throwables1) {
            throwables1.printStackTrace();
        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
        }

    }

    public static ObservableList<jobs> getDatausers() throws SQLException, ClassNotFoundException {

       Connection dbConnection = new DataBaseHandler().getDbConnection();
        ObservableList<jobs> list = FXCollections.observableArrayList();
        try {
            PreparedStatement ps = dbConnection.prepareStatement("select * from jobs");

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new jobs(Integer.parseInt(rs.getString("id")), rs.getString("name_firm"), rs.getString("activity"), rs.getString("addres"), rs.getString("phoneNumber")));
            }
        }
        catch (SQLException throwables2){
            throwables2.printStackTrace();
        }
        catch (Exception e){
            e.printStackTrace();
        }


        return list;
    }

}