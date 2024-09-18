package pe.edu.upc.talent_tune.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pe.edu.upc.talent_tune.entities.Usuario;
import pe.edu.upc.talent_tune.repositories.IUsuarioRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class JwtUserDetailsService implements UserDetailsService {
    @Autowired
    private IUsuarioRepository repo;


    @Override
    public UserDetails loadUserByUsername(String nombreusuario) throws UsernameNotFoundException {
        Usuario usuario = repo.findOneByUsername(nombreusuario);
        if (usuario == null) {
            throw new UsernameNotFoundException(String.format("User not exists", nombreusuario));
    }

        List<GrantedAuthority> roles = new ArrayList<>();

        usuario.getroles().forEach(rol -> {
            roles.add(new SimpleGrantedAuthority(rol.getTipoRol()));
        });

        UserDetails ud = new org.springframework.security.core.userdetails.User(usuario.getNombreUsuario(), usuario.getContrasenia(), usuario.getEnabled(), true, true, true, roles);

        return ud;
}
