package pe.edu.upc.talent_tune.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.talent_tune.entities.Contenido;
import pe.edu.upc.talent_tune.repositories.IContenidoRepository;
import pe.edu.upc.talent_tune.serviceinterfaces.IContenidoService;

import java.util.List;

@Service
public class ContenidoServiceImplement implements IContenidoService {

    @Autowired
    private IContenidoRepository coR;

    @Override
    public List<Contenido> list() {
        return coR.findAll();
    }

    @Override
    public void insert(Contenido contenido) {
        coR.save(contenido);
    }

    @Override
    public void update(Contenido contenido) {
        coR.save(contenido);
    }

    @Override
    public void delete(int id) {
        coR.deleteById(id);
    }

    @Override
    public List<String[]> obtenerFiltroContenido(String tipocontenido) {
        return coR.filtroContenido(tipocontenido);
    }
}
