package com.systechafrica.pointofsale;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class UserDBPractice {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        UserDBPractice db = new UserDBPractice();
        // get the class name
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String user ="root";
            String password="";
            String url="jdbc:mysql://localhost:3306/mabera";
            // lets define the connection
            Connection connection =DriverManager.getConnection(url,user,password);
            // let us create a statement
            Statement statement = connection.createStatement();
            String createTable= "CREATE TABLE IF NOT EXISTS users(user_id INT AUTO_INCREMENT PRIMARY KEY, user_name VARCHAR(255) NOT NULL, password VARCHAR(255) NOT NULL);";
            int noUpdated = statement.executeUpdate(createTable);
            System.out.println("The status is "+noUpdated);
            String insertQuery = "INSERT INTO users(user_name,password) VALUES(?,?);";
            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
            User madeUser = db.makeUSer(myScanner);
            preparedStatement.setString(1, madeUser.getUserName());
            preparedStatement.setString(2, madeUser.getPassword());

            int noOFResults = preparedStatement.executeUpdate();
            System.out.println("The number of results is "+noOFResults);
            
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            System.out.println("The Class not Found exception is "+e.getMessage());   
        
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("The SQL error is "+e.getMessage());
        }

       
    }

    private User makeUSer(Scanner myScanner) {
        // lets get the user details from the console 
        System.out.print("Kindly Enter your username: ");
        String username =myScanner.nextLine();
        System.out.print("Kindly Enter yout password: ");
        String password =myScanner.nextLine();

        User user = new User(username, password);
        return user;
    }    
}
