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
import resources.lib.domain.Deputado;
import resources.lib.domain.Partido;
import resources.lib.persistence.ConfigManager;
import resources.lib.persistence.JdbcConnection;

public class DeputadoDAOjdbc implements DeputadoDAO {

	private static DeputadoDAO singleton;

	// DAO de candidato eh singleton
	public static synchronized DeputadoDAO getInstance() {
		if(singleton == null) {
			singleton = new DeputadoDAOjdbc();
		}
		return singleton;
	}

	public void salvar(Deputado obj) {
		JdbcConnection jconn = new JdbcConnection(ConfigManager.getJdbcConfig());
		Connection conn = jconn.getConnection();
		PreparedStatement ps = null;
		ResultSet rsID;
		int lastIndex = 0;
		try {
			if(obj.getId() == Candidato.NEW) {
				ps = conn.prepareStatement("INSERT INTO Candidato(numero, nome, id_partido, id_cargo, nascimento, sexo, foto, site, apelido) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
			} else {
				ps = conn.prepareStatement("UPDATE Candidato SET id=?, numero=?, nome=?, id_partido=?, id_cargo=?, nascimento=?, sexo=?, foto=?, site=?, apelido=? WHERE id=?");
				ps.setInt(1, obj.getId());
				ps.setInt(11, obj.getLastId());
				lastIndex++;
			}
			CandidatoJDBC.prepareStatement(ps, obj, lastIndex); //Atributos comuns de Candidato são preparados
			//Inserir campos a partir do índice 9 + lastIndex
			ps.setString(lastIndex + 9, obj.getApelido());
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
		} catch (Exception ex) {
			System.err.println("Erro ao inserir a Candidato\n" + ex.getLocalizedMessage());
		}
	}

	public void excluir(Deputado obj) {
		CandidatoJDBC.delete(obj);
	}
	
	public List<Deputado> obter() {
		ResultSet result = CandidatoJDBC.getAll("Deputado");
		List<Deputado> list = new ArrayList<Deputado>();
		try {
			while(result.next()) {
				Deputado d;
				d = new Deputado(result.getInt("id"), result.getInt("numero"), result.getString("nome"), Partido.get(result.getInt("id_partido")), Cargo.get(result.getInt("id_cargo")), new Date(result.getDate("nascimento").getTime()), result.getString("sexo").charAt(0), result.getString("foto"), result.getString("site"), result.getString("apelido"));
				list.add(d);
				if(!Deputado.conflicts(d)) {
					Deputado.register(d);
				} else {
					Deputado.override(d); //Atualizar o objeto na lista global
				}
			}
		} catch (SQLException se) {
			System.err.println(se.getLocalizedMessage());
		}
		return list;
	}
	
	public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}
}
