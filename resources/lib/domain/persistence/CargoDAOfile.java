package resources.lib.domain.persistence;

import java.util.List;

import resources.lib.domain.Cargo;

public class CargoDAOfile implements CargoDAO {

    public void salvar(Cargo obj) {}

    public void excluir(Cargo obj) {}

    public List<Cargo> obter() {return null;}
    
    public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}
}
