package pe.edu.upc.talent_tune.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.talent_tune.dtos.CategoriaEventoDTO;
import pe.edu.upc.talent_tune.dtos.EventoDTO;
import pe.edu.upc.talent_tune.entities.Evento;
import pe.edu.upc.talent_tune.serviceinterfaces.IEventoService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/eventos")
public class EventoController {

    @Autowired
    private IEventoService eS;

    @PreAuthorize("hasAnyAuthority('TALENTO','ADMINISTRADOR','SEGUIDOR','MANAGER')")
    @GetMapping
    public List<EventoDTO> listar() {
        return eS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, EventoDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    @PreAuthorize("hasAnyAuthority('TALENTO','ADMINISTRADOR','MANAGER')")
    public void registrar(@RequestBody EventoDTO dto) {
        ModelMapper m = new ModelMapper();
        Evento ev = m.map(dto, Evento.class);
        eS.insert(ev);
    }

    @PatchMapping
    @PreAuthorize("hasAnyAuthority('TALENTO','ADMINISTRADOR','MANAGER')")
    public void modificar(@RequestBody EventoDTO dto) {
        ModelMapper m = new ModelMapper();
        Evento ev = m.map(dto, Evento.class);
        eS.update(ev);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('TALENTO','ADMINISTRADOR','MANAGER')")
    public void eliminar(@PathVariable("id") Integer id) {
        eS.delete(id);
    }

    @GetMapping("/EventoPorCategoria/{tipoCategoria}")
    @PreAuthorize("hasAnyAuthority('ADMINISTRADOR')")
    public List<CategoriaEventoDTO> CatPorEvento(@PathVariable String tipoCategoria) {
        List<String[]> lista = eS.CatPorEvento(tipoCategoria);
        List<CategoriaEventoDTO> listaDTO = new ArrayList<>();
        for (String[] columna : lista) {
            CategoriaEventoDTO dto = new CategoriaEventoDTO();
            dto.setIdEvento(Integer.parseInt(columna[0]));
            dto.setNombreEvento(columna[1]);
            dto.setDescripcionEvento(columna[2]);
            listaDTO.add(dto);
        }
        return listaDTO;
    }

}
