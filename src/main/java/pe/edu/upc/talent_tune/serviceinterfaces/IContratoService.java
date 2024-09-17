package pe.edu.upc.talent_tune.serviceinterfaces;

import pe.edu.upc.talent_tune.entities.Contrato;
import pe.edu.upc.talent_tune.entities.Mensaje;

import java.util.List;

public interface IContratoService {


    public List<Contrato> list();

    public void insert(Contrato contrato);

    public void update(Contrato contrato);

    public void delete(int id);
}
