package com.systechafrica.pointofsale;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class UserDBPractice implements UserController {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        UserDBPractice db = new UserDBPractice();
        // get the class name
        try {
            // get the connection object from the overriden method from the interface class
            Connection connection =db.connect();
            // let us create a statement to create the tables first and then to insert the query, both of which are DDLs             
            String createTable= "CREATE TABLE IF NOT EXISTS users(user_id INT AUTO_INCREMENT PRIMARY KEY, user_name VARCHAR(255) NOT NULL,password VARCHAR(255) NOT NULL);";
            int noCreatedTables = db.executeUpdate(createTable);
            System.out.println("The number of created tables are "+noCreatedTables);
            String insertQuery = "INSERT INTO users(user_name,password) VALUES(?,?);";
            int affectedRows =db.prepare(insertQuery,myScanner);
            System.out.println("The number of inserted rows are "+affectedRows);            
            ResultSet resultSet = db.getUserData("SELECT * FROM users");
            while(resultSet.next()){
                String userName = resultSet.getString("user_name");
                String pass = resultSet.getString("password");
                System.out.println("The username is "+userName);
                System.out.println("The password is "+pass);
            }            
        } catch (Exception e) {
            // TODO Auto-generated catch block
            System.out.println("The  exception is "+e.getMessage());           
        }       
    }
    @Override
    public void close() {
        // TODO Auto-generated method stub
        try {
            connect().close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("The SQL Exception is "+e.getMessage());
        }
        
    }

    @Override
    public Connection connect() {        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String user ="root";
            String password="";
            String url="jdbc:mysql://localhost:3306/mabera";
            // lets define the connection
            Connection connection =DriverManager.getConnection(url,user,password);
             return connection;
        } catch (ClassNotFoundException e) {
            System.out.println("The class not found exception is "+e.getMessage());
        } catch(SQLException e){
            System.out.println("The SQL exception is "+e.getMessage());
        }
        return null;              
    }
    // function to get user data
    public ResultSet getUserData(String query){
        // now lets retrieve the data of this user from the database
        ResultSet resultSet = exequteQuery(query);
        return resultSet;
    }

    @Override
    public int executeUpdate(String query) {
        try {
            Statement statement = connect().createStatement();
            int noUpdated = statement.executeUpdate(query);
            return noUpdated;
        } catch (SQLException e) {
            System.out.println("The SQl Exception is "+e.getMessage());
        }
        return 0;
    }

    @Override
    public ResultSet exequteQuery(String query) {
        Statement statement;
        try {
            statement = connect().createStatement();
            ResultSet resultSet =statement.executeQuery(query);
            return resultSet;
        } catch (SQLException e) {
            System.out.println("The SQL Exception is "+e.getMessage());
        }        
        return null;
    }
    @Override
    public int prepare(String query, Scanner myScanner) {
        try {
           
            // lets come up with a prepared statement that will take in user 
            System.out.print("Enter your username: ");
            String uName = myScanner.nextLine();
            System.out.print("Enter your password: ");
            String password =myScanner.nextLine();
            PreparedStatement preparedStatement = connect().prepareStatement(query);
            preparedStatement.setString(1, uName);
            preparedStatement.setString(2, password);

            // let us execute the query
            int noOfUpdatedFields = preparedStatement.executeUpdate();
            return noOfUpdatedFields;

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("The SQL Exception is "+e.getMessage());
        }

        return 0;
    }

    

  
}