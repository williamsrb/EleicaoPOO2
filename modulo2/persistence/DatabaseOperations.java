package modulo2.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Map;

import resources.lib.persistence.ConfigManager;
import resources.lib.persistence.JdbcConnection;

public final class DatabaseOperations {	
	public static String getUrnaPassword() {
		String password = null;
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
		return password;
	}
	
	public static void writeVotingResults(List<Map<String, String>> votes) {
		Map<String, String> map;
		int size = votes.size(), i;
		JdbcConnection jconn = new JdbcConnection(ConfigManager.getJdbcConfig());
		Connection conn = jconn.getConnection();
		PreparedStatement ps = null;
		for(i = 0; i < size; i++) {
			map = votes.get(i);
			try {
				ps = conn.prepareStatement("INSERT INTO \"Votos\"(num_deputado, num_governador, num_presidente) VALUES (?, ?, ?)");
				ps.setInt(1, Integer.parseInt(map.get("deputado")));
				ps.setInt(2, Integer.parseInt(map.get("governador")));
				ps.setInt(3, Integer.parseInt(map.get("presidente")));
				ps.executeUpdate();
			} catch (SQLException se) {
				System.err.println(resources.lib.other.Debug.getTrace(se.getLocalizedMessage()));
			}
		}
		jconn.disconnect();
	}
}