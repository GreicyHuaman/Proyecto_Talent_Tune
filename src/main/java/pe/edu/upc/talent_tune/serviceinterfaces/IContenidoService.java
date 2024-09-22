package pe.edu.upc.talent_tune.serviceinterfaces;

import pe.edu.upc.talent_tune.entities.Contenido;

import java.util.List;

public interface IContenidoService {

    public List<Contenido> list();

    public void insert(Contenido contenido);

    public void update(Contenido contenido);

    public void delete(int id);

    public List<String[]> obtenerFiltroContenido(String tipocontenido);

}
