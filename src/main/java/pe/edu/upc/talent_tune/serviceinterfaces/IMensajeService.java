package pe.edu.upc.talent_tune.serviceinterfaces;

import pe.edu.upc.talent_tune.entities.Mensaje;

import java.util.List;

public interface IMensajeService {

    public List<Mensaje> list();

    public void insert(Mensaje mensaje);

    public void update(Mensaje mensaje);

    public void delete(int id);
}
