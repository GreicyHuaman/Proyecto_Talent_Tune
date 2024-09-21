package pe.edu.upc.talent_tune.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.talent_tune.entities.Persona;
import pe.edu.upc.talent_tune.repositories.IPersonaRepository;
import pe.edu.upc.talent_tune.serviceinterfaces.IPersonaService;

import java.util.List;

@Service
public class PersonaServiceImplement implements IPersonaService {
    @Autowired
    private IPersonaRepository pR;

    @Override
    public List<Persona> list() {
        return pR.findAll();
    }

    @Override
    public void insert(Persona persona) {
        pR.save(persona);
    }

    @Override
    public void update(Persona persona) {
        pR.save(persona);
    }

    @Override
    public void delete(int id) {
        pR.deleteById(id);
    }

    @Override
    public List<Persona> buscar(String nombre) {
        return pR.buscar(nombre);
    }

    @Override
    public List<String[]> edadPromedioArtistas() {
        return pR.edadPromedioArtistas();
    }


}