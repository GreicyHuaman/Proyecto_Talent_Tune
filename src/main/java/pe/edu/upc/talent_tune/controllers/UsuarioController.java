package pe.edu.upc.talent_tune.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.talent_tune.dtos.UsuarioDTO;
import pe.edu.upc.talent_tune.dtos.UsuarioMasVisualizacionesDTO;
import pe.edu.upc.talent_tune.entities.Usuario;
import pe.edu.upc.talent_tune.serviceinterfaces.IUsuarioService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@PreAuthorize("hasAnyAuthority('TALENTO','ADMINISTRADOR','SEGUIDOR','MANAGER')")
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private IUsuarioService uS;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping
    public List<UsuarioDTO> listarUsuarios() {
        return uS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, UsuarioDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void registrar(@RequestBody UsuarioDTO dto) {
        ModelMapper m = new ModelMapper();
        Usuario usuario = m.map(dto, Usuario.class);
        String encodedPassword = passwordEncoder.encode(usuario.getPassword());
        usuario.setPassword(encodedPassword);
        uS.insert(usuario);
    }

    @PatchMapping
    public void modificar(@RequestBody UsuarioDTO dto) {
        ModelMapper m = new ModelMapper();
        Usuario usuario = m.map(dto, Usuario.class);
        uS.update(usuario);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id) {
        uS.delete(id);
    }

    @GetMapping("/pais")
    public List<UsuarioDTO> buscarPorPais(@RequestParam("pais") String pais) {
        return uS.buscarPorPais(pais).stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, UsuarioDTO.class);
        }).collect(Collectors.toList());
    }

    @GetMapping("/estudios")
    public List<UsuarioDTO> buscarPorEstudios(@RequestParam("estudios") String estudios) {
        return uS.buscarPorEstudios(estudios).stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, UsuarioDTO.class);
        }).collect(Collectors.toList());
    }


    @GetMapping("/usuariosmasvisualizaciones")
    public List<UsuarioMasVisualizacionesDTO> obtenerUsuariosMasVisualizaciones(){
        List<String[]>lista=uS.obtenerUsuarioMasVisualizaciones();
        List<UsuarioMasVisualizacionesDTO>listaDTO=new ArrayList<>();
        for(String[]columna:lista){
            UsuarioMasVisualizacionesDTO dto=new UsuarioMasVisualizacionesDTO();
            dto.setNombre(columna[0]);
            dto.setVisualizaciones(Integer.parseInt(columna[1]));
            listaDTO.add(dto);
        }
        return listaDTO;
    }

}
