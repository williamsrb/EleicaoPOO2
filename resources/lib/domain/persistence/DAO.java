package resources.lib.domain.persistence;

import java.util.List;

import resources.lib.other.Singleton;

public interface DAO<T> extends Singleton {
    public void salvar(T obj);
    public void excluir(T obj);
    public List<T> obter();
}
 
