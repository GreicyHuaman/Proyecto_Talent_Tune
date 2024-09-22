package pe.edu.upc.talent_tune.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.talent_tune.dtos.CategoriaContenidoDTO;
import pe.edu.upc.talent_tune.dtos.ContenidoDTO;
import pe.edu.upc.talent_tune.dtos.FiltroContenidoDTO;
import pe.edu.upc.talent_tune.dtos.UsuarioDTO;
import pe.edu.upc.talent_tune.entities.Contenido;
import pe.edu.upc.talent_tune.serviceinterfaces.IContenidoService;

import java.util.ArrayList;
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


    @GetMapping("/ContenidoPorCategoria/{tipoCategoria}")
    public List<CategoriaContenidoDTO> CatPorContenido(@PathVariable String tipoCategoria) {
        List<String[]> lista = coS.CatPorContenido(tipoCategoria);
        List<CategoriaContenidoDTO> listaDTO = new ArrayList<>();
        for (String[]columna : lista) {
            CategoriaContenidoDTO dto = new CategoriaContenidoDTO();
            dto.setIdContenido(Integer.parseInt(columna[0]));
            dto.setTitulo(columna[1]);
            dto.setTipoContenido(columna[2]);
            dto.setVisualizaciones(Integer.parseInt(columna[3]));
            listaDTO.add(dto);
        }
        return listaDTO;
    }

    @GetMapping("/filtrocontenido")
    public List<FiltroContenidoDTO> obtenerFiltroContenido(@RequestParam("tipocontenido") String tipocontenido) {
        return coS.obtenerFiltroContenido(tipocontenido).stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, FiltroContenidoDTO.class);
        }).collect(Collectors.toList());
    };

}
