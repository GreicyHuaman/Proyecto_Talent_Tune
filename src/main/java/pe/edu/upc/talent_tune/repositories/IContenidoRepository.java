package pe.edu.upc.talent_tune.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.talent_tune.entities.Contenido;

import java.util.List;

@Repository
public interface IContenidoRepository extends JpaRepository<Contenido, Integer> {
    @Query(" SELECT c.titulo, c.visualizaciones\n" +
            " FROM Contenido c\n" +
            " WHERE c.visualizaciones > 500")
    List<String[]> visualizacionescontenido(@Param("titulo") String titulo);
}
