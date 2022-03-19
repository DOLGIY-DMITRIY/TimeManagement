package com.application.tm;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesManager {
    private final Properties prop;


    public PropertiesManager() throws IOException {
        prop = new Properties();
        InputStream PATH = new FileInputStream("application.properties");
        prop.load(PATH);
    }

    public String getHost(){
        return prop.getProperty("db.host");
    }

    public String getPort(){
        return prop.getProperty("db.port");
    }

    public String getUser(){
        return prop.getProperty("db.user");
    }

    public String getPass(){
        return prop.getProperty("db.pass");
    }

    public String getName(){
        return prop.getProperty("db.name");
    }


}
