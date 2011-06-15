package resources.lib.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class JdbcConnection {
	
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
        } catch (SQLException se) {
        	System.err.println("Não foi possível estabelecer conexão com o banco: " + url + "\n" + resources.lib.other.Debug.getTrace(se.getLocalizedMessage()));
        } catch (ClassNotFoundException cnfe) {
        	System.err.println("Driver não encontrado\n" + resources.lib.other.Debug.getTrace(cnfe.getLocalizedMessage()));
		}
		return conn;
	}
	
	public void disconnect() {
		try {
			this.connection.close();
		} catch (SQLException se) {
			System.err.println(resources.lib.other.Debug.getTrace(se.getLocalizedMessage()));
		}
	}
	
	public static boolean isConnectionWorking() {
		JdbcConnection jconn = new JdbcConnection(ConfigManager.getJdbcConfig());
		Connection conn = jconn.getConnection();
		boolean result = false;
		if(conn != null) {
			jconn.disconnect();
			result = true;
		}
		return result;
	}
}