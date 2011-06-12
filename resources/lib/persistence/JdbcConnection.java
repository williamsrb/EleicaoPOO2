package resources.lib.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcConnection {
	
	private Connection connection;

	public JdbcConnection(JdbcConfig config) {
		this.connection = connect(config.getUsername(), config.getPassword(), config.getUrl(), config.getDriver());
	}
	public Connection getConnection() {
		return this.connection;
	}
	
	private Connection connect(String username, String password, String url, String driver) {
		Connection conn = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, username, password);
			System.err.println("Driver de conexão não encontrado!");
        } catch (SQLException se) {
        	System.err.println("Não foi possível estabelecer conexão com o banco: " + url + "\n" + se.getLocalizedMessage());
        } catch (ClassNotFoundException cnfe) {
        	System.err.println("Driver não encontrado\n" + cnfe.getLocalizedMessage());
		}
		return conn;
	}
	
	public void disconnect() {
		try {
			this.connection.close();
		} catch (SQLException se) {
			System.err.println(se.getLocalizedMessage());
		}
	}
}
