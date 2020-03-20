package com.pushpadangi;

import com.pushpadangi.DbHelper.DBHandler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {
    private static DBHandler dbHandler;
    private static Connection connection;
    private static PreparedStatement preparedStatement;

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        dbHandler = new DBHandler();
        connection = dbHandler.getDBConnection();
//        setData();
//        getData();
//        updateDatabase("Don","Khanal","Rolpa",23,"khanldon",1);
        deleteRow(1);
    }

    public static void setData() throws SQLException {

        String insertQuery = "INSERT INTO users(firstname,lastname,addresss,age,username) VALUES(?,?,?,?,?)";
        preparedStatement = connection.prepareStatement(insertQuery);
        preparedStatement.setString(1, "Hari");
        preparedStatement.setString(2, "Dangi");
        preparedStatement.setString(3, "Rolpa");
        preparedStatement.setInt(4, 22);
        preparedStatement.setString(5, "hari_dc");
        preparedStatement.executeUpdate();
    }

    public static void getData() throws SQLException {
        String getData = "SELECT * FROM users";
        preparedStatement = connection.prepareStatement(getData);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            System.out.println("First Name : " + resultSet.getString("firstname"));
            System.out.println("Last Name : " + resultSet.getString("lastname"));
        }
    }

    public static void updateDatabase(String firstname, String lastname, String addresss, int age, String username, int id) throws SQLException {
        String update = "UPDATE users SET firstname=?,lastname=?,addresss=?,age=?,username=?"+ "WHERE userid=?";
        preparedStatement = connection.prepareStatement(update);
        preparedStatement.setString(1, firstname);
        preparedStatement.setString(2, lastname);
        preparedStatement.setString(3, addresss);
        preparedStatement.setInt(4, age);
        preparedStatement.setString(5, username);
        preparedStatement.setInt(6,id);
        preparedStatement.executeUpdate();
        preparedStatement.close();

    }

    public static void deleteRow(int id) throws SQLException{
        String deleteQuery = "DELETE from users";
        preparedStatement = connection.prepareStatement(deleteQuery);
        preparedStatement.execute();
        preparedStatement.close();
    }
}
