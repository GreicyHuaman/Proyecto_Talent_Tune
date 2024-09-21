package pe.edu.upc.talent_tune.serviceinterfaces;

import pe.edu.upc.talent_tune.entities.Banda;

import java.util.List;

public interface IBandaService {

    public List<Banda> list();

    public void insert(Banda banda);

    public void update(Banda banda);

    public void delete(int id);

    List<String[]> BandasMasContratosActivos();
}
