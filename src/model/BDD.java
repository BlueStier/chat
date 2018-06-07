package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class BDD {
	private Connection _connect;
	
	public Connection getInstance() {
		
		if (_connect == null) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				
			} catch (Exception e) {
				e.printStackTrace();
				
			}
			try {
				_connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/chat?useSSL=false","root","root");
								
			} catch (SQLException e) {
				return null;
			}
		}
		return _connect;

	}
}
