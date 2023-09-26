package com.systechafrica.part3.jdbc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Logger;

import com.systechafrica.part3.logging.CustomFormatter;
import com.systechafrica.part3.logging.FileLogging;

public class DatabaseAccessdemo {
     private static final Logger LOGGER = Logger.getLogger(FileLogging.class.getName());

    public static void main(String[] args) {
        Scanner myScanner= new Scanner(System.in);
        try{
            FileHandler fileHandler = new FileHandler("log.txt");
            CustomFormatter formatter = new CustomFormatter();
            LOGGER.addHandler(fileHandler);
            // STep 1 add postgress to the pom.xml file
            fileHandler.setFormatter(formatter);

            Class.forName("com.mysql.cj.jdbc.Driver");
            // Step 3create a connnection to the database
            String connvectionUrl="jdbc:mysql://localhost:3306/mabera";
            String user= "root";
            String password="";
            // Create connection
            Connection connection = DriverManager.getConnection(connvectionUrl, user, password);
            
            // create a statement from the connection
            Statement statement = connection.createStatement();
            String sqlQuery="CREATE TABLE IF NOT EXISTS tasks(task_id INT AUTO_INCREMENT PRIMARY KEY, title VARCHAR(255) NOT NULL, start_date DATE, due_date DATE,status TINYINT NOT NULL,priority TINYINT NOT NULL, description VARCHAR(255) NOT NULL);";

            int noOfUpdatedFields=statement.executeUpdate(sqlQuery);
            LOGGER.info("The number of Uodated fields are: "+noOfUpdatedFields);
            String insertQuery = "INSERT INTO TASKS(title,start_date,due_date,status,priority,description) VALUES(?,?,?,?,?,?);";
            Tasks tasks = getTaskFromUser(myScanner);
            // get reasy with the prepared statements
            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
            preparedStatement.setString(1, tasks.getTitle());
            preparedStatement.setString(2, tasks.getStart_date().toString());
            preparedStatement.setString(3, tasks.getDue_date().toString());
            preparedStatement.setInt(4, tasks.getStatus());
            preparedStatement.setInt(5, tasks.getPriority());
            preparedStatement.setString(6, tasks.getDescription());

            int noOFRows= preparedStatement.executeUpdate();
            LOGGER.info("The number of affected rows is: "+noOFRows);

            String selectAll ="SELECT * FROM TASKS";
            Statement selectStatment = connection.createStatement();

            ResultSet resultSet = selectStatment.executeQuery(selectAll);

            while(resultSet.next()){ 
                resultSet.toString();
                String id = resultSet.getString("task_id");
                String title = resultSet.getString("title");
                LocalDate starDate = LocalDate.parse(resultSet.getString("start_date"));
                LocalDate dueDate = LocalDate.parse(resultSet.getString("due_date"));
                int status =resultSet.getInt("status");
                int priority = resultSet.getInt("priority");
                String description = resultSet.getString("description");

                Tasks dbTask =new Tasks(id, title, starDate, dueDate, status, priority, description);
                dbTask.toString();
            }
                        

        }catch( SecurityException e){
            LOGGER.severe("Unable to obtain security permissions for the log file: "+e.getMessage());
        }catch(IOException e){
            LOGGER.severe("Unable to obtain read/write permissions for the log file: "+e.getMessage());
        }catch(ClassNotFoundException e){
            LOGGER.severe("Unable to obtain class for the JDBC driver: "+e.getMessage());
        }catch(SQLException e){
            LOGGER.severe("The sql exception is "+e.getMessage());
        }


    }

    private static Tasks getTaskFromUser(Scanner myScanner) {
        System.out.print("Enter the title: ");
        String title = myScanner.nextLine();
        System.out.print("Enter the start date: ");
        LocalDate startDate = LocalDate.parse(myScanner.nextLine());
        System.out.print("Enter the Due date: ");
        LocalDate dueDate= LocalDate.parse(myScanner.nextLine());
        System.out.print("Enter the Status: ");
        int status = myScanner.nextInt();
        System.out.print("Enter the priority level: ");
        int priority = myScanner.nextInt();
        // remove /n as a result of nextInt()
        myScanner.nextLine();
        System.out.print("Enter the item description: ");
        String description = myScanner.nextLine();

        // create an object of the task class and pass the values from the console to its constructor
        Tasks task = new Tasks(title,startDate,dueDate,status,priority,description);
        
        return task;
    }
}
