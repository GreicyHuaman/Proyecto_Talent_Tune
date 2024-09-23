package pe.edu.upc.talent_tune.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.talent_tune.dtos.EdadPromedioArtistasDTO;
import pe.edu.upc.talent_tune.dtos.PersonaDTO;
import pe.edu.upc.talent_tune.entities.Persona;
import pe.edu.upc.talent_tune.serviceinterfaces.IPersonaService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/personas")
public class PersonaController {
    @Autowired
    private IPersonaService pS;

    @GetMapping
    public List<PersonaDTO> listar() {
        return pS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, PersonaDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void registrar(@RequestBody PersonaDTO dto) {
        ModelMapper m = new ModelMapper();
        Persona pe = m.map(dto, Persona.class);
        pS.insert(pe);
    }
    @PatchMapping
    public void modificar (@RequestBody PersonaDTO dto){
        ModelMapper m = new ModelMapper();
        Persona pe = m.map(dto, Persona.class);
        pS.update(pe);
    }
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id) {
        pS.delete(id);
    }

    @GetMapping("/busquedas")
    public List<PersonaDTO> buscar(@RequestParam String nombre) {
        return pS.buscar(nombre).stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, PersonaDTO.class);
        }).collect(Collectors.toList());
    }

    @GetMapping("/EdadPromedioArtistas")
    public List<EdadPromedioArtistasDTO> edadPromedioArtistas(){
        List<String[]>lista=pS.edadPromedioArtistas();
        List<EdadPromedioArtistasDTO>listaDTO=new ArrayList<>();
        for (String[] columna:lista) {
            EdadPromedioArtistasDTO dto=new EdadPromedioArtistasDTO();
            dto.setEdadPromedio(Integer.parseInt(columna[0]));
            listaDTO.add(dto);
        }
        return listaDTO;
    }

}
