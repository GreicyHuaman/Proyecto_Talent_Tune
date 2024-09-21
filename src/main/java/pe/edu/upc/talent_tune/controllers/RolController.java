package pe.edu.upc.talent_tune.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.talent_tune.dtos.ConsultaRolCategoriaDTO;
import pe.edu.upc.talent_tune.dtos.RolDTO;
import pe.edu.upc.talent_tune.entities.Rol;
import pe.edu.upc.talent_tune.serviceinterfaces.IRolService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/roles")
public class RolController {

    @Autowired
    private IRolService rS;

    @GetMapping
    public List<RolDTO> listarRoles() {
        return rS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, RolDTO.class);
        }).collect(Collectors.toList());
    };

    @PostMapping
    public void registrar(@RequestBody RolDTO dto) {
        ModelMapper m = new ModelMapper();
        Rol rol = m.map(dto, Rol.class);
        rS.insert(rol);
    }
    @PatchMapping
    public void modificar (@RequestBody RolDTO dto){
        ModelMapper m = new ModelMapper();
        Rol rol = m.map(dto, Rol.class);
        rS.update(rol);
    }
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id) {
        rS.delete(id);
    }

    @GetMapping("/Consulta Rol-Categoría")
    public List<ConsultaRolCategoriaDTO> Ver(@RequestParam String tipoCategoria){
        List<String[]> Lista = rS.obtenerconsulta(tipoCategoria);
        List<ConsultaRolCategoriaDTO> ListaDTO = new ArrayList<>();
        for (String[] columna : Lista){
            ConsultaRolCategoriaDTO DTO = new ConsultaRolCategoriaDTO();
            DTO.setTipoRol(columna[0]);
            DTO.setTipoCategoria(columna[1]);
            ListaDTO.add(DTO);
        }
        return ListaDTO;
    }

}
