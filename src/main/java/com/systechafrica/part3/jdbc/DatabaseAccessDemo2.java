package com.systechafrica.part3.jdbc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;

import com.systechafrica.part3.logging.CustomFormatter;

public class DatabaseAccessDemo2 {
    private static final Logger LOGGER =Logger.getLogger(DatabaseAccessDemo2.class.getName());
    public static void main(String[] args){
        FileHandler fileHandler;
        try {
            fileHandler = new FileHandler("log.txt");
            CustomFormatter formatter = new CustomFormatter();
            LOGGER.addHandler(fileHandler);
            // STep 1 add postgress to the pom.xml file
            fileHandler.setFormatter(formatter);
            // real step 1 , load the database driver
            Class.forName("com.mysql.cj.jdbc.Driver"); 
            // step 2 get the connection from the Driver manager
            String connectionUrl="jdbc:mysql://localhost:3306/javase";
            String user = "javase";
            String password ="javase";
            Connection connection = DriverManager.getConnection(connectionUrl, user, password);

        } catch (SecurityException e) {
            LOGGER.severe("Unable to obtain security credentials on the databse"+e.getMessage());
        } catch (IOException e) {
            // TODO Auto-generated catch block
            LOGGER.severe("Unable to obtain read/write operations on the databse"+e.getMessage());        
        }catch(ClassNotFoundException e){
            LOGGER.severe("Unable to find class"+e.getMessage());
        }catch(SQLException e){
            LOGGER.severe("Unable to obtain connection to the database: "+e.getMessage());
        }
            
    }
}
