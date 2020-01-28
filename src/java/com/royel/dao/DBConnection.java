package com.royel.dao;

import java.sql.*;

/**
 * class DBConnection
 * 
 * The intention of this class is to create a connection with the database. This
 * class created with Default access modifiers, this is package protected only
 * can access form same package.
 * 
 * @author Royel
 * @version 1.0
 * @since 04/08/2017.
 * 
 */
class DBConnection {

	// DBConnection object for maintaining singleton design pattern
	private static DBConnection singletonInstance;
	private static Connection connection;

	/**
	 * Makes DBConnection to be instantiated only within the class. This needs
	 * because at the same time there should not be multiple connection to the
	 * same database. First call the forName class and make a new instance then
	 * established a connection with user provided String url, userName,
	 * password and singletonInstance variable is Assigned by this constructor.
	 */

	private DBConnection() {
		String url = "jdbc:mysql://localhost:3306/hospital";
		String userName = "root";
		String password = "root";
		singletonInstance = this;

		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			connection = DriverManager.getConnection(url, userName, password);
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * Method for getting the singleton instance of the DBConnection class. This
	 * is package protected, so only used inside this package Generate singleton
	 * object of this class.
	 * 
	 * @return DBConnection single object of this class.
	 * @exception SQLException on input
	 */

	static DBConnection dbConnection() {
		return (singletonInstance != null) ? singletonInstance : new DBConnection();
	}

	/**
	 * For getting the prepared statement this of given SQL queries This is
	 * package protected, so only used inside this package
	 * 
	 * @param sql String type data
	 * @return an statement for executing queries.
	 * @exception SQLException on input
	 */

	PreparedStatement getPreparedStatement(String sql) throws SQLException {
		return connection.prepareStatement(sql);
	}
}
