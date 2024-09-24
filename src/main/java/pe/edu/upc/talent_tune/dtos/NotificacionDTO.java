package pe.edu.upc.talent_tune.dtos;

import pe.edu.upc.talent_tune.entities.Evento;
import pe.edu.upc.talent_tune.entities.Usuario;

public class NotificacionDTO {

    private int idNotificacion;
    private String detalle;
    private Usuario usuario;
    private Evento evento;

    public int getIdNotificacion() {
        return idNotificacion;
    }

    public void setIdNotificacion(int idNotificacion) {
        this.idNotificacion = idNotificacion;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }
}
