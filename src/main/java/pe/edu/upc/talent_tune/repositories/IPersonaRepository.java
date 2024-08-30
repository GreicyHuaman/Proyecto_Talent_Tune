package pe.edu.upc.talent_tune.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.talent_tune.entities.Persona;

import java.util.List;

@Repository
public interface IPersonaRepository extends JpaRepository<Persona, Integer> {
    @Query("Select p from Persona p where p.nombres like %:nombre%")
    public List<Persona> buscar(@Param("nombre") String nombre);

}