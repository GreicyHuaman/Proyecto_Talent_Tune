package pe.edu.upc.talent_tune.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.talent_tune.entities.Rol;

import java.util.List;

@Repository
public interface IRolRepository extends JpaRepository<Rol, Integer> {
    @Query(value=" SELECT r.tipo_rol, c.tipo_categoria\n" +
            " FROM Rol r\n" +
            " JOIN Categoria c ON r.id_categoria = c.id_categoria;",nativeQuery = true)
    public List<String[]> obtenerconsulta(@Param("tipoCategoria") String tipoCategoria);
}
