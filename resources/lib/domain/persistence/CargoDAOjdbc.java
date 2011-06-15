package resources.lib.domain.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import resources.lib.domain.Cargo;
import resources.lib.persistence.ConfigManager;
import resources.lib.persistence.JdbcConnection;

public class CargoDAOjdbc implements CargoDAO {

	private static CargoDAOjdbc singleton;
	
	private CargoDAOjdbc() {}
	
	// DAO de candidato eh singleton
	public static synchronized CargoDAO getInstance() {
		if(singleton == null) {
			singleton = new CargoDAOjdbc();
		}
		return singleton;
	}

	public void salvar(Cargo obj) {
		JdbcConnection jconn = new JdbcConnection(ConfigManager.getJdbcConfig());
		Connection conn = jconn.getConnection();
		PreparedStatement ps = null;
		ResultSet rsID;
		int lastIndex = 0;
		try {
			if(obj.getId() == Cargo.NEW) {
				ps = conn.prepareStatement("INSERT INTO Cargo(digitos, nome) VALUES (?, ?)", Statement.RETURN_GENERATED_KEYS);
			} else {
				ps = conn.prepareStatement("UPDATE Candidato SET id=?, digitos=?, nome=? WHERE id=?");
				ps.setInt(1, obj.getId());
				ps.setInt(4, obj.getLastId());
				lastIndex++;
			}
			ps.setInt(lastIndex + 1, obj.getDigitos());
			ps.setString(lastIndex + 2, obj.getNome());
			ps.executeUpdate();
			if(obj.getId() == Cargo.NEW) {
				rsID = ps.getGeneratedKeys();
				if(rsID.next()) {
					obj.setId(rsID.getInt("id")); //Aplicando o ID gerado no baco de dados ao objeto
				} else {
					throw new SQLException();
				}
			}
			obj.setLastId(obj.getId());
			jconn.disconnect();
			stock(obj); //Atualiza a lista global
		} catch (Exception ex) {
			System.err.println("Erro ao inserir o Cargo\n" + ex.getLocalizedMessage());
		}
	}

	public void excluir(Cargo obj) {
		JdbcConnection jconn = new JdbcConnection(ConfigManager.getJdbcConfig());
		Connection conn = jconn.getConnection();
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement("DELETE FROM Cargo WHERE id=?");
			ps.setInt(1, obj.getId());
			ps.executeUpdate();
			jconn.disconnect();
			purge(obj);
		} catch (SQLException se) {
			System.err.println("Erro ao apagar o Cargo\n" + se.getLocalizedMessage());
		}
	}
	
	public List<Cargo> obter() {
		ResultSet result = getAll();
		List<Cargo> list = new ArrayList<Cargo>();
		try {
			if(result != null) {
				while(result.next()) {
					Cargo c;
					c = new Cargo(result.getInt("id"), result.getInt("digitos"), result.getString("nome"));
					list.add(c);
					stock(c);
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
			if(conn != null) {
				st = conn.createStatement();
				result = st.executeQuery("SELECT * FROM Cargo");
				jconn.disconnect();
			}
		} catch (SQLException se) {
			System.err.println(se.getLocalizedMessage());
		}
		return result;
	}
	
	private static void purge(Cargo obj) {
		Cargo.unregister(obj);
	}
	
	private static void stock(Cargo obj) {
		Cargo.register(obj);
	}
	
	public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}
}
 
