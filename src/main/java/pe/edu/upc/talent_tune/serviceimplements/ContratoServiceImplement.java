package pe.edu.upc.talent_tune.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.talent_tune.entities.Contrato;
import pe.edu.upc.talent_tune.repositories.IContratoRepository;
import pe.edu.upc.talent_tune.repositories.IMensajeRepository;
import pe.edu.upc.talent_tune.serviceinterfaces.IContratoService;

import java.util.List;

@Service
public class ContratoServiceImplement implements IContratoService {
    @Autowired
    private IContratoRepository ctR;


    @Override
    public List<Contrato> list() {
        return ctR.findAll();
    }

    @Override
    public void insert(Contrato contrato) {
        ctR.save(contrato);
    }

    @Override
    public void update(Contrato contrato) {
        ctR.save(contrato);
    }

    @Override
    public void delete(int id) {
        ctR.deleteById(id);
    }
}
