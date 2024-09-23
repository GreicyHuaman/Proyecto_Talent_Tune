package pe.edu.upc.talent_tune.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.talent_tune.dtos.*;
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
    @PreAuthorize("hasAnyAuthority('TALENTO','ADMINISTRADOR','SEGUIDOR','MANAGER')")
    public List<ContenidoDTO> listarContenido(){
        return coS.list().stream().map(x->{
            ModelMapper m = new ModelMapper();
            return m.map(x, ContenidoDTO.class);
        }).collect(Collectors.toList());

    }

    @PostMapping
    @PreAuthorize("hasAnyAuthority('TALENTO','ADMINISTRADOR','SEGUIDOR','MANAGER')")
    public void registrar(@RequestBody ContenidoDTO dto){
        ModelMapper m = new ModelMapper();
        Contenido contenido = m.map(dto, Contenido.class);
        coS.update(contenido);
    }

    @PatchMapping
    @PreAuthorize("hasAnyAuthority('TALENTO','ADMINISTRADOR','SEGUIDOR','MANAGER')")
    public void modificar(@RequestBody ContenidoDTO dto){
        ModelMapper m = new ModelMapper();
        Contenido contenido = m.map(dto, Contenido.class);
        coS.update(contenido);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('TALENTO','ADMINISTRADOR','SEGUIDOR','MANAGER')")
    public void eliminar(@PathVariable("id") Integer id){
        coS.delete(id);
    }


    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
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

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @GetMapping("/filtrocontenido")
    public List<FiltroContenidoDTO> obtenerFiltroContenido(@RequestParam("tipocontenido") String tipocontenido) {
        return coS.obtenerFiltroContenido(tipocontenido).stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, FiltroContenidoDTO.class);
        }).collect(Collectors.toList());
    };

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @GetMapping("/cantidadesvisua")
    public List<VisualizacionesContenidoDTO> Ver(@RequestParam String titulo){
        List<String[]> Lista = coS.visualizacionescontenido(titulo);
        List<VisualizacionesContenidoDTO> hcListaDTO = new ArrayList<>();
        for (String[] columna : Lista){
            VisualizacionesContenidoDTO DTO = new VisualizacionesContenidoDTO();
            DTO.setTitulo(columna[0]);
            DTO.setVisualizaciones(Integer.parseInt(columna[1]));
            hcListaDTO.add(DTO);
        }
        return hcListaDTO;
    }

}
