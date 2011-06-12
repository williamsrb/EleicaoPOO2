package resources.lib.domain.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import resources.lib.domain.Candidato;
import resources.lib.persistence.JdbcConnection;



public class CandidatoDAOjdbc implements CandidatoDAO {

    private static CandidatoDAO instance = null;

    // DAO de pessoa eh singleton
    public static CandidatoDAO getInstance() {
        if (instance == null) {
            instance = new CandidatoDAOjdbc();
        }
        return instance;
    }

    public void salvar(Candidato obj) {
        Connection conexao = JdbcConnection.getConnection();
        PreparedStatement ps = null;
        try {
            ps = conexao.prepareStatement("INSERT INTO Candidato VALUES (?,?)");
            ps.setInt(1, obj.getId());
            ps.setString(2, obj.getNome());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Erro ao inserir a Candidato");
            ex.printStackTrace();
        }
    }

    public void excluir(Candidato obj) {

    }

    public List<Candidato> obter() {
        return null;
    }


/*    public static void main(String args[]){
    	JdbcConnection conexao = new JdbcConnection();
        conexao.connect("org.postgresql.Driver", "jdbc:postgresql://localhost/Teste", "postgres", "postgres");
        CandidatoDAOjdbc pessoaDAO = new CandidatoDAOjdbc();
        Candidato pedro = new Deputado();
        //pedro.setId(5);
        //pedro.setNome("Pedro");
        pessoaDAO.salvar(pedro);
        conexao.disconnect();
    }
*/
}
