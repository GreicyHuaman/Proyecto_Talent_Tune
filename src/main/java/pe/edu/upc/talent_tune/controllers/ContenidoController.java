package pe.edu.upc.talent_tune.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.talent_tune.dtos.ContenidoDTO;
import pe.edu.upc.talent_tune.dtos.FiltroContenidoDTO;
import pe.edu.upc.talent_tune.dtos.UsuarioDTO;
import pe.edu.upc.talent_tune.entities.Contenido;
import pe.edu.upc.talent_tune.serviceinterfaces.IContenidoService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/contenidos")
public class ContenidoController {

    @Autowired
    private IContenidoService coS;

    @GetMapping
    public List<ContenidoDTO> listarContenido(){
        return coS.list().stream().map(x->{
            ModelMapper m = new ModelMapper();
            return m.map(x, ContenidoDTO.class);
        }).collect(Collectors.toList());

    }

    @PostMapping
    public void registrar(@RequestBody ContenidoDTO dto){
        ModelMapper m = new ModelMapper();
        Contenido contenido = m.map(dto, Contenido.class);
        coS.update(contenido);
    }

    @PatchMapping
    public void modificar(@RequestBody ContenidoDTO dto){
        ModelMapper m = new ModelMapper();
        Contenido contenido = m.map(dto, Contenido.class);
        coS.update(contenido);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id){
        coS.delete(id);
    }

    @GetMapping("/filtrocontenido")
    public List<FiltroContenidoDTO> obtenerFiltroContenido(@RequestParam("tipocontenido") String tipocontenido) {
        return coS.obtenerFiltroContenido(tipocontenido).stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, FiltroContenidoDTO.class);
        }).collect(Collectors.toList());
    };

}
