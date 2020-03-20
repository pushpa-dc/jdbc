package com.pushpadangi.DbHelper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBHandler extends Configs {
    Connection connection;
    public Connection getDBConnection () throws ClassNotFoundException, SQLException {
        String conString = "jdbc:mysql://"+dbHost+":"+dbPort+"/"+dbName;
        Class.forName("com.mysql.jdbc.Driver");

        connection= DriverManager.getConnection(conString,dbUsre,password);
        return connection;
    }

}
