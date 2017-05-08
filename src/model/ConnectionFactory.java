package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	private final static String url = "jdbc:mysql://localhost/caelumJavaWeb";
	private final static String user = "caelum";
	private final static String password = "123";

	public static Connection getConnection(){

		try {
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection(url, user, password);
		} catch (SQLException | ClassNotFoundException e) {
			throw new RuntimeException("erro ao conectar:" + e);
			
		}
	}
}