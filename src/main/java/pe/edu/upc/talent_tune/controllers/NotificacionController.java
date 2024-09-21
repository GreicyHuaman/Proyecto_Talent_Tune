package pe.edu.upc.talent_tune.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.talent_tune.dtos.NotificacionDTO;
import pe.edu.upc.talent_tune.entities.Notificacion;
import pe.edu.upc.talent_tune.serviceinterfaces.INotificacionService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/notificaciones")
public class NotificacionController {

    @Autowired
    private INotificacionService nS;

    @GetMapping
    public List<NotificacionDTO> listarNotificacion(){
        return nS.list().stream().map(x->{
            ModelMapper m = new ModelMapper();
            return m.map(x,NotificacionDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void registrar(@RequestBody NotificacionDTO dto){
        ModelMapper m = new ModelMapper();
        Notificacion notificacion = m.map(dto, Notificacion.class);
        nS.update(notificacion);
    }

    @PatchMapping
    public void modificar(@RequestBody NotificacionDTO dto){
        ModelMapper m = new ModelMapper();
        Notificacion notificacion = m.map(dto, Notificacion.class);
        nS.update(notificacion);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id){
        nS.delete(id);
    }

}
