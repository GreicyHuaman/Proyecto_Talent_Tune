package pe.edu.upc.talent_tune.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.talent_tune.entities.Usuario;

import java.util.List;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario, Integer> {
  @Query("Select u from Usuario u where u.persona.pais like %:pais%")
    public List<Usuario> buscarPorPais(@Param("pais") String pais);

  @Query("Select u from Usuario u where u.persona.estudios like %:estudios%")
    public List<Usuario> buscarPorEstudios(@Param("estudios") String estudios);
}
