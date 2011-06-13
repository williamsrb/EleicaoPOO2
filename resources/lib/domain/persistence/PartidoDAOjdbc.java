package resources.lib.domain.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import resources.lib.domain.Partido;
import resources.lib.persistence.ConfigManager;
import resources.lib.persistence.JdbcConnection;

public class PartidoDAOjdbc implements PartidoDAO {

	private static PartidoDAO singleton;

	// DAO de candidato eh singleton
	public static synchronized PartidoDAO getInstance() {
		if(singleton == null) {
			singleton = new PartidoDAOjdbc();
		}
		return singleton;
	}

	public void salvar(Partido obj) {
		JdbcConnection jconn = new JdbcConnection(ConfigManager.getJdbcConfig());
		Connection conn = jconn.getConnection();
		PreparedStatement ps = null;
		ResultSet rsID;
		int lastIndex = 0;
		try {
			if(obj.getId() == Partido.NEW) {
				ps = conn.prepareStatement("INSERT INTO Partido(sigla, nome, numero) VALUES (?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
			} else {
				ps = conn.prepareStatement("UPDATE Candidato SET id=?, sigla=?, nome=?, numero=? WHERE id=?");
				ps.setInt(1, obj.getId());
				ps.setInt(5, obj.getLastId());
				lastIndex++;
			}
			ps.setString(lastIndex + 1, obj.getSigla());
			ps.setString(lastIndex + 2, obj.getNome());
			ps.setInt(lastIndex + 3, obj.getNumero());
			ps.executeUpdate();
			if(obj.getId() == Partido.NEW) {
				rsID = ps.getGeneratedKeys();
				if(rsID.next()) {
					obj.setId(rsID.getInt("id")); //Aplicando o ID gerado no baco de dados ao objeto
				} else {
					throw new SQLException();
				}
			}
			obj.setLastId(obj.getId());
			jconn.disconnect();
		} catch (Exception ex) {
			System.err.println("Erro ao inserir o Partido\n" + ex.getLocalizedMessage());
		}
	}

	public void excluir(Partido obj) {
		JdbcConnection jconn = new JdbcConnection(ConfigManager.getJdbcConfig());
		Connection conn = jconn.getConnection();
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement("DELETE FROM Partido WHERE id=?");
			ps.setInt(1, obj.getId());
			ps.executeUpdate();
			jconn.disconnect();
		} catch (SQLException se) {
			System.err.println("Erro ao apagar o Partido\n" + se.getLocalizedMessage());
		}
	}
	
	public List<Partido> obter() {
		ResultSet result = getAll();
		List<Partido> list = new ArrayList<Partido>();
		try {
			while(result.next()) {
				Partido d;
				d = new Partido(result.getInt("id"), result.getString("sigla"), result.getString("nome"), result.getInt("numero"));
				list.add(d);
				if(!Partido.conflicts(d)) {
					Partido.register(d);
				} else {
					Partido.override(d); //Atualizar o objeto na lista global
				}
			}
		} catch (SQLException se) {
			System.err.println(se.getLocalizedMessage());
		}
		return list;
	}
	
	private static ResultSet getAll() {
		JdbcConnection jconn = new JdbcConnection(ConfigManager.getJdbcConfig());
		Connection conn = jconn.getConnection();
		Statement st = null;
		ResultSet result = null;
		st = (Statement) result; //temp
		try {
			st = conn.createStatement();
			result = st.executeQuery("SELECT * FROM Partido");
			jconn.disconnect();
		} catch (SQLException se) {
			System.err.println(se.getLocalizedMessage());
		}
		return result;
	}
	
	public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}
}
