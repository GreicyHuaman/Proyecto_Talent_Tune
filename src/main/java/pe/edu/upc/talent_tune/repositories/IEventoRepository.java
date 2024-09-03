package pe.edu.upc.talent_tune.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.talent_tune.entities.Evento;

@Repository
public interface IEventoRepository extends JpaRepository<Evento, Integer> {

}
