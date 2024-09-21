package pe.edu.upc.talent_tune.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.talent_tune.entities.Banda;
import pe.edu.upc.talent_tune.repositories.IBandaRepository;
import pe.edu.upc.talent_tune.serviceinterfaces.IBandaService;

import java.util.List;

@Service
public class BandaServiceImplement implements IBandaService {

    @Autowired
    private IBandaRepository bR;

    @Override
    public List<Banda> list() {
        return bR.findAll();
    }

    @Override
    public void insert(Banda banda) {
        bR.save(banda);
    }

    @Override
    public void update(Banda banda) {
        bR.save(banda);
    }

    @Override
    public void delete(int id) {
        bR.deleteById(id);
    }

    @Override
    public List<String[]> BandasMasContratosActivos() {
        return bR.BandasMasContratosActivos();
    }
}
