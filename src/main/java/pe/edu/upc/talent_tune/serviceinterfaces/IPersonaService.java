package pe.edu.upc.talent_tune.serviceinterfaces;

import pe.edu.upc.talent_tune.entities.Persona;

import java.util.List;

public interface IPersonaService {
    public List<Persona> list();

    public void insert(Persona persona);

    public void update(Persona persona);

    public void delete(int id);

    public List<Persona> buscar(String nombres);

    public List<String[]> edadPromedioArtistas();
}
