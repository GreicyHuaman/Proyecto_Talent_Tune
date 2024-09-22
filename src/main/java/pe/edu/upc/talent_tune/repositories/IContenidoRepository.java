package pe.edu.upc.talent_tune.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.talent_tune.entities.Contenido;

import java.util.List;

@Repository
public interface IContenidoRepository extends JpaRepository<Contenido, Integer> {
    @Query(value = "SELECT c.id_contenido, c.titulo, c.tipo_contenido, c.visualizaciones\n" +
            " FROM contenido c\n" +
            " JOIN categoria cat ON c.id_categoria = cat.id_categoria\n" +
            " WHERE cat.tipo_categoria = :tipoCategoria", nativeQuery = true)
    public List<String[]> CatPorContenido(@Param("tipoCategoria") String tipoCategoria);
}
