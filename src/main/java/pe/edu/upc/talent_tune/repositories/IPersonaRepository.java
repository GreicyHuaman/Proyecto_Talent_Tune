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

    @Query(value = "SELECT ROUND(AVG(EXTRACT(YEAR FROM AGE(p.fecha_nacimiento)))) AS edad_promedio\n" +
            " FROM persona p\n" +
            " JOIN usuario u ON p.id_persona = u.id_persona\n" +
            " JOIN roles r ON u.id_usuario = r.id_usuario\n" +
            " WHERE r.tipo_rol = 'TALENTO'",nativeQuery = true)
    public List<String[]>edadPromedioArtistas();
}