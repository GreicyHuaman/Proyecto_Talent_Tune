package pe.edu.upc.talent_tune.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.talent_tune.dtos.UsuarioDTO;
import pe.edu.upc.talent_tune.entities.Usuario;
import pe.edu.upc.talent_tune.serviceinterfaces.IUsuarioService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private IUsuarioService uS;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @PostMapping
    public void registrar(@RequestBody UsuarioDTO dto) {
        ModelMapper m = new ModelMapper();
        Usuario u = m.map(dto, Usuario.class);
        String encodedPassword = passwordEncoder.encode(u.getContrasenia());
        u.setContrasenia(encodedPassword);
        uS.insert(u);
    }


    @GetMapping
    public List<UsuarioDTO> listarUsuarios() {
        return uS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, UsuarioDTO.class);
        }).collect(Collectors.toList());
    };


    @PatchMapping
    public void modificar (@RequestBody UsuarioDTO dto){
        ModelMapper m = new ModelMapper();
        Usuario usuario = m.map(dto, Usuario.class);
        uS.update(usuario);
    }
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id) {
        uS.delete(id);
    }


}
