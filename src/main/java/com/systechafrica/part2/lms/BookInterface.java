package com.systechafrica.part2.lms;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Scanner;


public interface BookInterface {
    Book createBook(Scanner scanner);
    boolean removeBook(Scanner scanner);
    boolean lendBook(Scanner scanner);
    boolean receiveBorrowed(Scanner scanner);
    Connection connect();
    int executeUpdate(String query);
    int preparedStatement(String query, Scanner scanner);
    ResultSet executeQuery(String query);
    void viewBooks();
    void close();
}
