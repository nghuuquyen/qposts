package models.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLiteDBConnection implements DBConnection {
	// Database connect string
	// Must put this file in resources folder configured in maven pom.xml.
	String DB_FILE_PATH = "/databases/qposts.db";

	@Override
	public Connection getConnection() {
		Connection conn = null;

		try {
			// Load JDBC driver.
			Class.forName("org.sqlite.JDBC");

			// Create a connection to the database
			conn = DriverManager.getConnection("jdbc:sqlite::resource:" + getClass().getResource(DB_FILE_PATH));
			
			System.out.println("Connection to SQLite has been established.");
			return conn;
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}

		return null;
	}

	public static void main(String[] args) {
		DBConnection db = new SQLiteDBConnection();

		// Test connection.
		db.getConnection();
	}
}
