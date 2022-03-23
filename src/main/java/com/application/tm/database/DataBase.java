package com.application.tm.database;

import com.application.tm.entities.User;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DataBase extends DataBaseConfig {

    private final String INSERT_USER = "INSERT INTO user (UID, username, password) VALUES (?, ?, ?)";
    private final String CHECK_USERNAME = "SELECT * FROM user WHERE username=?";

    public DataBase() throws IOException, SQLException, ClassNotFoundException {
        super();
    }

    public boolean isExist(String username){
        try {
            PreparedStatement statement = connection.prepareStatement(CHECK_USERNAME);

            statement.setString(1, username);

            ResultSet result = statement.executeQuery();
            if (result.next()) {
                return true;
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }

        return false;
    }

    public void addUser(User user){
        try{
            PreparedStatement statement = connection.prepareStatement(INSERT_USER);

            statement.setString(1, user.getUUID().toString());
            statement.setString(2, user.getUsername());
            statement.setString(3, user.getPassword());

            int res = statement.executeUpdate();
        } catch (SQLException exception){
            exception.printStackTrace();
        }
    }

}
