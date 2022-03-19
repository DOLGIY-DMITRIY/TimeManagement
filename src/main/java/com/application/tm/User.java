package com.application.tm;

import java.util.UUID;

public class User {

    private final String username;
    private final String password;
    private final UUID uuid;

    public User(String username, String password){
        this.username = username;
        this.password = password;
        uuid = UUID.randomUUID();
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public UUID getUuid() {
        return uuid;
    }
}
