package pe.edu.upc.talent_tune.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.talent_tune.entities.Usuario;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario, Integer> {
  @Query("Select u from Usuario u where u.persona.pais like %:pais%")
    public List<Usuario> buscarPorPais(@Param("pais") String pais);
}
