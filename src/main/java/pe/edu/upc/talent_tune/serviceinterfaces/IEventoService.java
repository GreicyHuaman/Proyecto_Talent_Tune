package pe.edu.upc.talent_tune.serviceinterfaces;

import pe.edu.upc.talent_tune.entities.Evento;

import java.util.List;

public interface IEventoService {
    public List<Evento> list();

    public void insert(Evento evento);

    public void update(Evento evento);

    public void delete(int id);
}
