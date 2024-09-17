package pe.edu.upc.talent_tune.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.talent_tune.entities.Mensaje;
import pe.edu.upc.talent_tune.repositories.IMensajeRepository;
import pe.edu.upc.talent_tune.serviceinterfaces.IMensajeService;

import java.util.List;

@Service
public class MensajeServiceImplement implements IMensajeService {

    @Autowired
    private IMensajeRepository mR;


    @Override
    public List<Mensaje> list() {
        return mR.findAll();
    }

    @Override
    public void insert(Mensaje mensaje) {
        mR.save(mensaje);
    }

    @Override
    public void update(Mensaje mensaje) {
        mR.save(mensaje);
    }

    @Override
    public void delete(int id) {
        mR.deleteById(id);
    }
}
