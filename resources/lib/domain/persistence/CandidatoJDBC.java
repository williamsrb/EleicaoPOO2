package resources.lib.domain.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

import resources.lib.domain.Candidato;
import resources.lib.persistence.ConfigManager;
import resources.lib.persistence.JdbcConnection;

public final class CandidatoJDBC {
	public static void prepareStatement(PreparedStatement ps, Candidato obj, int lastIndex) throws SQLException {
		//"INSERT INTO Candidato(numero, nome, id_partido, id_cargo, nascimento, sexo, foto, site, apelido, nome_vice, foto_vice) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"
		ps.setInt(lastIndex + 1, obj.getNumero());
		ps.setString(lastIndex + 2, obj.getNome());
		ps.setInt(lastIndex + 3, obj.getPartido().getId());
		ps.setInt(lastIndex + 4, obj.getCargo().getId());
		ps.setDate(lastIndex + 5, new java.sql.Date(obj.getNascimento().getTime()));
		ps.setString(lastIndex + 6, obj.getSexo().toString());
		ps.setString(lastIndex + 7, obj.getFoto());
		if(obj.getSite() == null) {
			ps.setNull(lastIndex + 8, Types.VARCHAR);
		} else {
			ps.setString(lastIndex + 8, obj.getSite());
		}
	}
	
	public static void delete(Candidato obj) {
		JdbcConnection jconn = new JdbcConnection(ConfigManager.getJdbcConfig());
		Connection conn = jconn.getConnection();
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement("DELETE FROM \"Candidato\" WHERE id=?");
			ps.setInt(1, obj.getId());
			ps.executeUpdate();
			jconn.disconnect();
		} catch (SQLException se) {
			System.err.println("Erro ao apagar o Candidato\n" + resources.lib.other.Debug.getTrace(se.getLocalizedMessage()));
		}
	}
	
	public static ResultSet getAll(String name) {
		JdbcConnection jconn = new JdbcConnection(ConfigManager.getJdbcConfig());
		Connection conn = jconn.getConnection();
		Statement st = null;
		ResultSet result = null;
		try {
			if(conn != null) {
				st = conn.createStatement();
				result = st.executeQuery("SELECT * FROM \"Candidato\" WHERE \"Candidato\".id IN" +
						"(SELECT \"Candidato\".id FROM \"Candidato\" JOIN \"Cargo\" ON \"Candidato\".id_cargo=\"Cargo\".id " +
						"WHERE \"Cargo\".nome='" + name + "')"); //Pega pelo nome do cargo
				jconn.disconnect();
			}
		} catch (SQLException se) {
			System.err.println(resources.lib.other.Debug.getTrace(se.getLocalizedMessage()));
		}
		return result;
	}
}