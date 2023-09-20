package com.systechafrica.part2.jdbc;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.DriverManager;

public class MySQLDataAcess implements DataAccess{

    public MySQLDataAcess(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            System.out.println(e.getMessage());
        }
    }
    @Override
    public void close() {
        // TODO Auto-generated method stub
        try {
            connect().close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println(e.getMessage());
        }
        
    }

    @Override
    public Connection connect() {
        // TODO Auto-generated method stub
        try {
            Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/mydatabase",
                "myuser",
                "secret");
                return connection;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println(e.getMessage());
            return null;
        }        
    }

    @Override
    public ResultSet executeQuery(String query) {
        // TODO Auto-generated method stub
        
        try {
            Statement statement = connect().createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            return resultSet;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
           System.out.println(e.getMessage());
            return null;
        }
        
       
    }

    @Override
    public int executeUpdate(String query) {
        Statement statement;
        try {
            statement = connect().createStatement();
            int numberOfFieldsUpdated = statement.executeUpdate(query);
            return numberOfFieldsUpdated;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println(e.getMessage());
            return 0;
        }
       
        // TODO Auto-generated method stub
        
    }
    
}
