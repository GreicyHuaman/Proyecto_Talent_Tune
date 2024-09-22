package pe.edu.upc.talent_tune.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.talent_tune.entities.Contenido;
import pe.edu.upc.talent_tune.entities.Usuario;

import java.util.List;

@Repository
public interface IContenidoRepository extends JpaRepository<Contenido, Integer> {

    @Query(value= "SELECT tipo_contenido, titulo, visualizaciones \n" +
            " FROM public.contenido\n" +
            " WHERE tipo_contenido like %:tipocontenido%\n" +
            " ORDER BY visualizaciones ASC", nativeQuery = true)
    public List<String[]> filtroContenido(@Param("tipocontenido") String tipocontenido);
}
