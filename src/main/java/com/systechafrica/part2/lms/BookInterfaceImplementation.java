package com.systechafrica.part2.lms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class BookInterfaceImplementation implements BookInterface{

    @Override
    public Book createBook(Scanner scanner) {
        System.out.print("Enter the ISBN number: ");
        String isbn = scanner.nextLine();
        System.out.print("Enter the Book Title: ");
        String title = scanner.nextLine();
        System.out.print("Enter the book author");
        String author = scanner.nextLine();
        Book book = new Book(isbn, title, author, true);
        return book;
    }

    @Override
    public boolean lendBook(Scanner scanner) {
        // first get the availability of the book, but before that, we need to retrieve the data from the database
        // pass the ISBN number
        System.out.print("Enter the ISBN number of the book you want to borrow: ");
        String isbn = scanner.nextLine();
        // create the SQL query to retrieve the book by the ISBN number
        String getBookString = "SELECT * FROM book WHERE book_isbn = '"+isbn+"'";
        //  get the book
        ResultSet results = executeQuery(getBookString);
        try {
            while(results.next()){
                boolean isAvailable = results.getBoolean("isAvailable");
                if(isAvailable){
                    return true;
                }
                return false;
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("The SQL exception is "+e.getMessage());
        }
        return false;
        
    }

    @Override
    public boolean receiveBorrowed(Scanner scanner) {
        // here we will receive a book that was borrowed,
        // first we will have to get the details of the book you are receiving
        System.out.print("Enter the ISBN number of the book you want to receive: ");
        String isbn = scanner.nextLine();
        // create the SQL query to retrieve the book by the ISBN number
        String getBookString = "SELECT * FROM book WHERE book_isbn = '"+isbn+"'";
        //  get the book
        ResultSet results = executeQuery(getBookString);
        try {
            while(results.next()){
                boolean isAvailable = results.getBoolean("isAvailable");
                if(isAvailable){
                    System.out.println("The book was not borrowed.");
                    return false;
                }else{
                    // create the sql statement to update the borrow status
                    String updateBorrowStatus = "UPDATE book SET isAvailable = '"+true+"' WHERE book_isbn ='"+isbn+"'";
                    // execute the update
                    int updatedIsAvailable = executeUpdate(updateBorrowStatus);
                    if(updatedIsAvailable >0){
                        System.out.println("Receive made successfully");
                        return true;
                    }
                }
                
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("The SQL exception is "+e.getMessage());
        }
        return false;
    }

    @Override
    public boolean removeBook(Scanner scanner) {
        // here we will receive a book that was borrowed,
        // first we will have to get the details of the book you are receiving
        System.out.print("Enter the ISBN number of the book you want to receive: ");
        String isbn = scanner.nextLine();
        // create the SQL query to retrieve the book by the ISBN number
        String getBookString = "SELECT * FROM book WHERE book_isbn = '"+isbn+"'";
        //  get the book
        ResultSet results = executeQuery(getBookString);
        try {
            while(results.next()){
                boolean isAvailable = results.getBoolean("isAvailable");
                if(isAvailable){
                    // create the sql statement to update the borrow status
                    String deleteBook = "DELETE * FROM book WHERE book_isbn ='"+isbn+"'";
                    // execute the update
                    int deleteBookInt = executeUpdate(deleteBook);
                    if(deleteBookInt >0){
                        System.out.println("Removal of book has been made successfully");
                        return true;
                    }                    
                }else{
                    System.out.println("You can not delete a book that has been borrowed");
                    return false;
                }
                
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("The SQL exception is "+e.getMessage());
        }
        return false;
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
        // TODO Auto-generated method stub
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String user = "root";
            String password="";
            String url = "jdbc:mysql://localhost:3306/mabera";
            Connection connect = DriverManager.getConnection(url, user, password);
            return connect;
        }catch(SQLException e){
            System.out.println("The SQL Exception is "+e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("The Class not found exception is "+e.getMessage());
        }     

        return null;
    }
    @Override
    public ResultSet executeQuery(String query) {
        try {
            Statement statement = connect().createStatement();
            ResultSet results = statement.executeQuery(query);
            return results;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("The SQL error is "+e.getMessage());
        }
        return null;
    }

    @Override
    public int executeUpdate(String query) {
        String createTableQuery = "CREATE TABLE IF not EXISTS book(book_id INT(11) AUTO INCREMENT PRIMARY KEY,book_isbn VARCHAR(255), book_title VARCHAR(255), book_author (VARCHAR 255), isAvailable boolean NOT NULL default 1)";
        // create a statement
        
        try {
            Statement statement = connect().createStatement();
            int tableCreated = statement.executeUpdate(createTableQuery);
            int noRecordsUpdated = statement.executeUpdate(query);
            return noRecordsUpdated;
        } catch (SQLException e) {
            System.out.println("The SQL exception is "+e.getMessage());
        }
        return 0;        
    }

    @Override
    public int preparedStatement(String query,Scanner scanner) {
        // TODO Auto-generated method stub
        String prepareStatmt = "INSERT INTO book VALUES(?,?,?)";
        int noRecordsInput = 0;
        try {
            PreparedStatement preparedStatement = connect().prepareStatement(prepareStatmt);
            System.out.print("How many books do you want to enter: ");
            int nBooks = scanner.nextInt();
            scanner.nextLine();
            // loop through to create books
            for(int i =0; i<nBooks;i++){
                Book book = createBook(scanner);
                preparedStatement.setString(i, book.getIsbn());
                preparedStatement.setString(i, book.getTitle());
                preparedStatement.setString(i, book.getAuthor());
                // execute the prepared statement
                int updatedRecords = preparedStatement.executeUpdate();
                noRecordsInput+=updatedRecords;
            }
            return noRecordsInput;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("The SQL exception is "+e.getMessage());
        }

        return 0;
    }

    @Override
    public void viewBooks() {
        // TODO Auto-generated method stub
        String viewBooksQuery = "SELECT * FROM book";
        ResultSet results = executeQuery(viewBooksQuery);
        try {
            while(results.next()){
                System.out.print(results.getString("book_author")+"  "+results.getString("book_title")+"  "+results.getString("book_isbn"));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("The SQL error is "+e.getMessage());
        }
    }
    
}
