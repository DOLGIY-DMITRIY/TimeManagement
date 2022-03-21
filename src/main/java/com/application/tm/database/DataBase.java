package com.application.tm.database;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DataBase extends DataBaseConfig {

    private final String INSERT_USER = "INSERT INTO user (UUID, username, password) VALUES (?, ?, ?)";
    private final String CHECK_USERNAME = "SELECT username FROM user WHERE username=?";

    public DataBase() throws IOException, SQLException {
        super();
    }

    public boolean isExist(String username){
        try {
            PreparedStatement statement = connection.prepareStatement(CHECK_USERNAME);

            statement.setString(1, username);

            int result = statement.executeUpdate();
            System.out.println(result);
        } catch (SQLException exception) {
            exception.printStackTrace();
        }

        return false;
    }

}
