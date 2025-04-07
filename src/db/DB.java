package db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DB {
	private static final String URL = "jdbc:mysql://localhost:3306/sistema_login";
	private static final String USUARIO = "root";
	private static final String SENHA = "hhdxyq6123";

	public static Connection conectar() {
		try {
			return DriverManager.getConnection(URL, USUARIO, SENHA);
		} catch (SQLException e) {
			System.out.println("Error of conection data base " + e.getMessage());
		}
		return null;
	}
	/*
	 * private static Connection conn = null;
	 * 
	 * public static Connection getConnection() { if (conn == null) { try {
	 * Properties props = loadProperties(); String url = props.getProperty("dburl");
	 * conn = DriverManager.getConnection(url, props); } catch (SQLException e) {
	 * throw new DbException(e.getMessage()); } } return conn; }
	 * 
	 * public static void closeConnection() { if (conn != null) { try {
	 * conn.close(); } catch (SQLException e) { throw new
	 * DbException(e.getMessage()); } } }
	 * 
	 * private static Properties loadProperties() { try (FileInputStream fs = new
	 * FileInputStream("src/db.properties")) { Properties props = new Properties();
	 * props.load(fs); return props; } catch (IOException e) { throw new
	 * DbException(e.getMessage()); } }
	 * 
	 * public static void closeStatement(Statement st) { if (st != null) { try {
	 * st.close(); } catch (SQLException e) { throw new DbException(e.getMessage());
	 * } } }
	 * 
	 * public static void closeResultSet(ResultSet rs) { if (rs != null) { try {
	 * rs.close(); } catch (SQLException e) { throw new DbException(e.getMessage());
	 * } } }
	 */
}