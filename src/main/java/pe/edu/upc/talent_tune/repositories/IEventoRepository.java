package pe.edu.upc.talent_tune.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.talent_tune.entities.Evento;

import java.util.List;

@Repository
public interface IEventoRepository extends JpaRepository<Evento, Integer> {
    @Query(value = "SELECT e.id_evento, e.nombre_evento, e.descripcion_evento\n" +
            " FROM evento e\n" +
            " JOIN categoria cat ON e.id_categoria = cat.id_categoria\n" +
            " WHERE cat.tipo_categoria = :tipoCategoria", nativeQuery = true)
    public List<String[]> CatPorEvento(@Param("tipoCategoria") String tipoCategoria);
}
