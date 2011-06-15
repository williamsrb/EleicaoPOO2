package modulo2.persistence;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import resources.lib.persistence.ConfigManager;
import resources.lib.persistence.JdbcConnection;

public final class DatabaseOperations {	
	public static String getUrnaPassword() {
		String stgmtd = ConfigManager.getStorageMethod();
		String password = null;
		if(stgmtd.equals("File")) {
			//De acordo com as especificações, não será implementado.
		} else {
			JdbcConnection jconn = new JdbcConnection(ConfigManager.getJdbcConfig());
			Connection conn = jconn.getConnection();
			Statement st = null;
			ResultSet result = null;
			try {
				if(conn != null) {
					st = conn.createStatement();
					result = st.executeQuery("SELECT senha FROM \"Urna\"");
					jconn.disconnect();
					if(result.next()) {
						password = result.getString("senha");
					}
				}
			} catch (SQLException se) {
				System.err.println(resources.lib.other.Debug.getTrace(se.getLocalizedMessage()));
			}
		}
		return password;
	}
}