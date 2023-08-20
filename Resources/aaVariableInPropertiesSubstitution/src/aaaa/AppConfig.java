package aaaa;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class AppConfig {
    public static void main(String[] args) {
        Properties properties = new Properties();
        
        try {
            FileInputStream configFile = new FileInputStream("config.properties");
            properties.load(configFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String dbHost = properties.getProperty("db.host");
        String dbPort = properties.getProperty("db.port");
        String dbUrl = "jdbc:mysql://" + dbHost + ":" + dbPort + "/mydatabase";
        String dbUsername = properties.getProperty("db.username");
        String dbPassword = properties.getProperty("db.password");

        System.out.println("Database URL: " + dbUrl);
        System.out.println("Username: " + dbUsername);
        System.out.println("Password: " + dbPassword);
    }
}
