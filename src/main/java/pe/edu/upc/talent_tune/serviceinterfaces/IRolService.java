package pe.edu.upc.talent_tune.serviceinterfaces;

import pe.edu.upc.talent_tune.entities.Rol;

import java.util.List;

public interface IRolService {
    public List<Rol> list();

    public void insert(Rol r);

    public void update(Rol r);

    public void delete(int id);
}
