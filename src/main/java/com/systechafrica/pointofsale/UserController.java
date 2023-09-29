package com.systechafrica.pointofsale;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Scanner;

public interface UserController {
   Connection  connect();
   ResultSet exequteQuery(String query);
   int executeUpdate(String query);
   int prepare(String query,Scanner myScanner);
   void close();
}
