package pe.edu.upc.talent_tune.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.talent_tune.dtos.BandaDTO;
import pe.edu.upc.talent_tune.dtos.BandasMasContratosActivosDTO;
import pe.edu.upc.talent_tune.entities.Banda;
import pe.edu.upc.talent_tune.serviceinterfaces.IBandaService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/bandas")
public class BandaController {

    @Autowired
    private IBandaService bS;

    @GetMapping
    @PreAuthorize("hasAnyAuthority('TALENTO','ADMINISTRADOR','SEGUIDOR','MANAGER')")
    public List<BandaDTO> listarBanda(){
        return bS.list().stream().map(x->{
            ModelMapper m = new ModelMapper();
            return m.map(x, BandaDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    @PreAuthorize("hasAnyAuthority('TALENTO','ADMINISTRADOR')")
    public void registrar(@RequestBody BandaDTO dto){
        ModelMapper m = new ModelMapper();
        Banda banda = m.map(dto, Banda.class);
        bS.update(banda);
    }

    @PatchMapping
    @PreAuthorize("hasAnyAuthority('TALENTO','ADMINISTRADOR')")
    public void modificar(@RequestBody BandaDTO dto){
        ModelMapper m = new ModelMapper();
        Banda banda = m.map(dto, Banda.class);
        bS.update(banda);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('TALENTO','ADMINISTRADOR')")
    public void eliminar(@PathVariable("id") Integer id){
        bS.delete(id);
    }

    @GetMapping("/BandasMasContratosActivos")
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public List<BandasMasContratosActivosDTO> obtener(){
        List<String[]>lista=bS.BandasMasContratosActivos();
        List<BandasMasContratosActivosDTO>listaDTO=new ArrayList<>();
        for (String[] columna:lista) {
            BandasMasContratosActivosDTO dto=new BandasMasContratosActivosDTO();
            dto.setNombreBanda(columna[0]);
            dto.setContratosActivos(Integer.parseInt(columna[1]));
            listaDTO.add(dto);
        }
        return listaDTO;
    }
}
