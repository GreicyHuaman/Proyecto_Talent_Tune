package pe.edu.upc.talent_tune.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.talent_tune.entities.Usuario;
import pe.edu.upc.talent_tune.repositories.IUsuarioRepository;
import pe.edu.upc.talent_tune.serviceinterfaces.IUsuarioService;

import java.util.List;

@Service
public class UsuarioServiceImplement implements IUsuarioService {
    @Autowired
    private IUsuarioRepository uR;


    @Override
    public List<Usuario> list() {
        return uR.findAll();
    }

    @Override
    public void insert(Usuario usuario) {
        uR.save(usuario);
    }

    @Override
    public void update(Usuario usuario) {
        uR.save(usuario);
    }

    @Override
    public void delete(int id) {
        uR.deleteById(id);
    }

    @Override
    public List<Usuario> buscarPorPais(String pais) {
        return uR.buscarPorPais(pais);
    }

    @Override
    public List<Usuario> buscarPorEstudios(String estudios) {
        return uR.buscarPorEstudios(estudios);
    }
}
