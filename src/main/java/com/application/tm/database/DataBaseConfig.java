package com.application.tm.database;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DataBaseConfig {

    private final String host = "localhost";
    private final String port = "3306";
    private final String user = "root";
    private final String pass = "sqlpassword";
    private final String name = "timemanagement";


    protected final Connection connection;

    // "jdbc:mysql://localhost:3306/javabase" - Example of URL

    public DataBaseConfig() throws IOException, SQLException, ClassNotFoundException {
        String URL = "jdbc:mysql://" + host + ":" + port + "/" + name;

        Class.forName("com.mysql.cj.jdbc.Driver");

        connection = DriverManager.getConnection(URL, user, pass);
    }

    public Connection getConnection() {
        return connection;
    }
}
