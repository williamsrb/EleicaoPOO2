package resources.lib.domain.persistence;

import java.util.List;

import resources.lib.domain.Governador;

public final class GovernadorDAOfile implements GovernadorDAO {

    public void salvar(Governador obj) {}

    public void excluir(Governador obj) {}

    public List<Governador> obter() {return null;}
    
    public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}
}