package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	private final static String URL = "jdbc:mysql://localhost:3306/agentdb";
	private final static String USERNAME = "root";
	private final static String PASSWORD = "root";
	private static Connection MyConn;
	private static DBConnection instance;

	private DBConnection(Connection MyConn) {
		DBConnection.MyConn = MyConn;
	}

	public static Connection getConnection() {
		if (instance == null) {
			try {
				MyConn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				System.out.println("Connected!");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return DBConnection.MyConn;
	}

}
