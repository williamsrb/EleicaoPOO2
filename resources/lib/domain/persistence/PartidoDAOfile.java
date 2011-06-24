package resources.lib.domain.persistence;

import java.util.List;

import resources.lib.domain.Partido;

public final class PartidoDAOfile implements PartidoDAO {

    public void salvar(Partido obj) {}

    public void excluir(Partido obj) {}

    public List<Partido> obter() {return null;}
    
    public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}
}