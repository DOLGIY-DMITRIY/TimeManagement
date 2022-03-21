package com.application.tm.database;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DataBase extends DataBaseConfig {

    private final String INSERT_USER = "INSERT INTO user (UUID, username, password) VALUES (?, ?, ?)";
    private final String CHECK_USERNAME = "SELECT * FROM user WHERE username=?";

    public DataBase() throws IOException, SQLException, ClassNotFoundException {
        super();
    }

    public boolean isExist(String username){
        try {
            PreparedStatement statement = connection.prepareStatement(CHECK_USERNAME);

            statement.setString(1, username);

            ResultSet result = statement.executeQuery();
            while(result.next()){
                String res = result.getString("username");
                System.out.println(res);
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }

        return false;
    }

}
