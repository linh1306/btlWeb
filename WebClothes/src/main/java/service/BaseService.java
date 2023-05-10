package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseService {
	  static final String DB_URL = "jdbc:mysql://localhost/clothes_store";
	  static final String USER = "root";
	  static final String PASS = "linh1306";
 
	  public static Connection getConnection()  throws SQLException
	  {
	     try {
	       Class.forName("com.mysql.jdbc.Driver");
	     } catch (ClassNotFoundException e) {
	       e.printStackTrace();
	     }
	    Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
	    return conn;
	  }
}
