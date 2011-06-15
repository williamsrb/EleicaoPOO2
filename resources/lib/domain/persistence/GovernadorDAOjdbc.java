package resources.lib.domain.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import resources.lib.domain.Candidato;
import resources.lib.domain.Cargo;
import resources.lib.domain.Governador;
import resources.lib.domain.Partido;
import resources.lib.persistence.ConfigManager;
import resources.lib.persistence.JdbcConnection;

public class GovernadorDAOjdbc implements GovernadorDAO {

	private static GovernadorDAOjdbc singleton;
	
	private GovernadorDAOjdbc() {}
	
	// DAO de candidato eh singleton
	public static synchronized GovernadorDAO getInstance() {
		if(singleton == null) {
			singleton = new GovernadorDAOjdbc();
		}
		return singleton;
	}

	public void salvar(Governador obj) {
		JdbcConnection jconn = new JdbcConnection(ConfigManager.getJdbcConfig());
		Connection conn = jconn.getConnection();
		PreparedStatement ps = null;
		ResultSet rsID;
		int lastIndex = 0;
		try {
			if(obj.getId() == Candidato.NEW) {
				ps = conn.prepareStatement("INSERT INTO Candidato(numero, nome, id_partido, id_cargo, nascimento, sexo, foto, site, nome_vice, foto_vice) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
			} else {
				ps = conn.prepareStatement("UPDATE Candidato SET id=?, numero=?, nome=?, id_partido=?, id_cargo=?, nascimento=?, sexo=?, foto=?, site=?, nome_vice=?, foto_vice=? WHERE id=?");
				ps.setInt(1, obj.getId());
				ps.setInt(12, obj.getLastId());
				lastIndex++;
			}
			CandidatoJDBC.prepareStatement(ps, obj, lastIndex); //Atributos comuns de Candidato são preparados
			//Inserir campos a partir do índice 9 + lastIndex
			ps.setString(lastIndex + 9, obj.getVice_nome());
			ps.setString(lastIndex + 10, obj.getVice_foto());
			ps.executeUpdate();
			if(obj.getId() == Candidato.NEW) {
				rsID = ps.getGeneratedKeys();
				if(rsID.next()) {
					obj.setId(rsID.getInt("id")); //Aplicando o ID gerado no baco de dados ao objeto
				} else {
					throw new SQLException();
				}
			}
			obj.setLastId(obj.getId());
			jconn.disconnect();
			stock(obj);
		} catch (Exception ex) {
			System.err.println("Erro ao inserir a Candidato\n" + ex.getLocalizedMessage());
		}
	}

	public void excluir(Governador obj) {
		CandidatoJDBC.delete(obj);
		purge(obj);
	}
	
	public List<Governador> obter() {
		ResultSet result = CandidatoJDBC.getAll("Governador");
		List<Governador> list = new ArrayList<Governador>();
		try {
			if(result != null) {
				while(result.next()) {
					Governador g;
					g = new Governador(result.getInt("id"), result.getInt("numero"), result.getString("nome"), Partido.get(result.getInt("id_partido")), Cargo.get(result.getInt("id_cargo")), new Date(result.getDate("nascimento").getTime()), result.getString("sexo").charAt(0), result.getString("foto"), result.getString("site"), result.getString("nome_vice"), result.getString("foto_vice"));
					list.add(g);
					stock(g);
				}
			}
		} catch (SQLException se) {
			System.err.println(se.getLocalizedMessage());
		}
		return list;
	}
	
	private static void purge(Governador obj) {
		Governador.unregister(obj);
	}
	
	private static void stock(Governador obj) {
		Governador.register(obj);
	}
	
	public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}
}
 
