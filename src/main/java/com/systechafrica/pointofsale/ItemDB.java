package com.systechafrica.pointofsale;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class ItemDB implements ItemController{
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        ItemDB db = new ItemDB();
        // get the class name
        try {
            // get the connection object from the overriden method from the interface class
            Connection connection =db.connect();
            // let us create a statement to create the tables first and then to insert the query, both of which are DDLs             
            String createTable= "CREATE TABLE IF NOT EXISTS items(item_id INT AUTO_INCREMENT PRIMARY KEY, item_name VARCHAR(255) NOT NULL, item_price INT(11), item_quantity INT(11));";
            int noCreatedTables = db.executeUpdate(createTable);
            // lets come up with a prepared statement that will take in user multi-input
            String insertQuery = "INSERT INTO items(item_name,item_price,item_quantity) VALUES(?,?,?);";
            int affectedRows =db.prepare(insertQuery,myScanner);
            System.out.println("The number of inserted rows are "+affectedRows);
            
            
        } catch (Exception e) {
            // TODO Auto-generated catch block
            System.out.println("The  exception is "+e.getMessage());   
        
        }

       
    }

    private Item makeItem(Scanner myScanner, int i) {        
        
        System.out.print("Enter the item Name "+(i+1)+": ");
        String itemName=myScanner.nextLine();
        System.out.print("Enter the item Price "+(i+1)+": ");
        int unitPrice=myScanner.nextInt();
        System.out.print("Enter the item Quantity "+(i+1)+": ");
        int quantity=myScanner.nextInt();        
        myScanner.nextLine();
        Item item = new Item(quantity, unitPrice,itemName);                    
        
        return item;
    }

    @Override
    public void close() {
        // TODO Auto-generated method stub
        
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

    @Override
    public Item createItem(Item item) {
        // TODO Auto-generated method stub
        return null;
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

        // ResultSet resultSet =connect().executeQuery(query);
        return null;
    }

    @Override
    public int prepare(String query, Scanner myScanner) {
        
        PreparedStatement preparedStatement;
        int affectedRows =0;
        try {
            preparedStatement = connect().prepareStatement(query);
            // get to know how any items you would want to enter
            System.out.print("How many items do you want to enter: ");
            int nItems=myScanner.nextInt();
            myScanner.nextLine();
            for(int i=0;i<nItems;i++){ 
                Item item = makeItem(myScanner,i);
                System.out.println(item.getItemName());
                System.out.println(item.getQuantity());
                System.out.println(item.getUnitPrice());
                preparedStatement.setString(1, item.getItemName());
                preparedStatement.setDouble(2, item.getUnitPrice());
                preparedStatement.setInt(3, item.getQuantity());

                int noOFResults = preparedStatement.executeUpdate();
                affectedRows+=noOFResults;
            }
            return affectedRows;
        } catch (SQLException e) {
            System.out.println("The SQL exception is "+e.getMessage());
        }

        
        return 0;
    }

  
}
