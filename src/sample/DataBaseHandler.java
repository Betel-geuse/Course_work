package sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public class DataBaseHandler extends  Configs {
    Connection dbConnection;

    public Connection getDbConnection() throws ClassNotFoundException, SQLException {
        String connectionString = "jdbc:mysql://" + dbHost + ":" + dbPort + "/" + dbName;

        Class.forName("com.mysql.jdbc.Driver");

        dbConnection = DriverManager.getConnection(connectionString, dbUser, dbPass);
        return dbConnection;
    }
        public void SignUpUser (String name_firm, String activity, String addres, String phoneNumber){
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

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

        }
    }
