package pe.edu.upc.talent_tune.serviceinterfaces;

import pe.edu.upc.talent_tune.entities.Usuario;

import java.util.List;

public interface IUsuarioService {
    public List<Usuario> list();
    public void insert(Usuario usuario);
    public void update(Usuario usuario);
    public void delete(int id);
    public List<Usuario> buscarPorPais(String pais);
    public List<Usuario> buscarPorEstudios(String estudios);
}
