package pe.edu.upc.talent_tune.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
<<<<<<< HEAD
import org.springframework.data.jpa.repository.Modifying;
=======
>>>>>>> d92ee2752fe27327021580c0fbf467a0571c339f
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.upc.talent_tune.entities.Usuario;

import java.util.List;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario, Integer> {
<<<<<<< HEAD
    public Usuario findOneByUsername(String username);

    //BUSCAR POR NOMBRE
    @Query("select count(u.username) from Users u where u.username =:username")
    public int buscarUsername(@Param("username") String nombre);


    //INSERTAR ROLES
    @Transactional
    @Modifying
    @Query(value = "insert into roles (rol, user_id) VALUES (:rol, :user_id)", nativeQuery = true)
    public void insRol(@Param("rol") String authority, @Param("user_id") Long user_id);
=======
  @Query("Select u from Usuario u where u.persona.pais like %:pais%")
    public List<Usuario> buscarPorPais(@Param("pais") String pais);

  @Query("Select u from Usuario u where u.persona.estudios like %:estudios%")
    public List<Usuario> buscarPorEstudios(@Param("estudios") String estudios);
>>>>>>> d92ee2752fe27327021580c0fbf467a0571c339f
}
