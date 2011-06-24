package resources.lib.domain.persistence;

import java.util.List;

import resources.lib.domain.Presidente;

public final class PresidenteDAOfile implements PresidenteDAO {

    public void salvar(Presidente obj) {}

    public void excluir(Presidente obj) {}

    public List<Presidente> obter() {return null;}
    
    public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}
}