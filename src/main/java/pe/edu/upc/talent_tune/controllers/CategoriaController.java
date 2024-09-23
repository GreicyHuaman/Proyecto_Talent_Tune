package pe.edu.upc.talent_tune.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.talent_tune.dtos.CategoriaDTO;
import pe.edu.upc.talent_tune.entities.Categoria;
import pe.edu.upc.talent_tune.serviceinterfaces.ICategoriaService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private ICategoriaService cS;

    @GetMapping
    @PreAuthorize("hasAnyAuthority('TALENTO','ADMINISTRADOR','SEGUIDOR','MANAGER')")
    public List<CategoriaDTO> listarCategorias() {
        return cS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, CategoriaDTO.class);
        }).collect(Collectors.toList());
    };

    @PostMapping
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public void registrar(@RequestBody CategoriaDTO dto) {
        ModelMapper m = new ModelMapper();
        Categoria ca = m.map(dto, Categoria.class);
        cS.insert(ca);
    }
    @PatchMapping
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public void modificar (@RequestBody CategoriaDTO dto){
        ModelMapper m = new ModelMapper();
        Categoria ca = m.map(dto, Categoria.class);
        cS.update(ca);
    }
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public void eliminar(@PathVariable("id") Integer id) {
        cS.delete(id);
    }
    @GetMapping("/busquedas")
    @PreAuthorize("hasAnyAuthority('TALENTO','ADMINISTRADOR','SEGUIDOR','MANAGER')")
    public List<CategoriaDTO> buscar(@RequestParam String tipoCategoria) {
        return cS.buscar(tipoCategoria).stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, CategoriaDTO.class);
        }).collect(Collectors.toList());
    }
}
