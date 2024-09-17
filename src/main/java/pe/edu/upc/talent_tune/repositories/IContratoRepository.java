package pe.edu.upc.talent_tune.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.talent_tune.entities.Contrato;
import pe.edu.upc.talent_tune.entities.Mensaje;

public interface IContratoRepository extends JpaRepository<Contrato, Integer> {
}
