package resources.lib.domain.persistence;

import java.util.List;

public interface DAO<T> {
    public void salvar(T obj);
    public void excluir(T obj);
    public List<T> obter();
}
