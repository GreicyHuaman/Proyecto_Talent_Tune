package pe.edu.upc.talent_tune.serviceinterfaces;

import pe.edu.upc.talent_tune.entities.Categoria;

import java.util.List;

public interface ICategoriaService {
    public List<Categoria> list();

    public void insert(Categoria categoria);

    public void update(Categoria categoria);

    public void delete(int id);

    public List<Categoria> buscar(String tipoCategoria);
}
