package resources.lib.domain.persistence;

import java.util.List;

import resources.lib.domain.Deputado;

public final class DeputadoDAOfile implements DeputadoDAO {

    public void salvar(Deputado obj) {}

    public void excluir(Deputado obj) {}

    public List<Deputado> obter() {return null;}
    
    public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}
}