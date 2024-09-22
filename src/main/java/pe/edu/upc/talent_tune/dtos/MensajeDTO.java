package pe.edu.upc.talent_tune.dtos;

import pe.edu.upc.talent_tune.entities.Banda;
import pe.edu.upc.talent_tune.entities.Usuario;

import java.time.LocalDate;
import java.util.Date;

public class MensajeDTO {

    private int idMensaje;

    private String contenidoMensaje;

    private LocalDate fechaMensaje;

    private Usuario idUsuarioManager;

    private Usuario idUsuarioTalento;

    private Banda banda;

    public int getIdMensaje() {
        return idMensaje;
    }

    public void setIdMensaje(int idMensaje) {
        this.idMensaje = idMensaje;
    }

    public String getContenidoMensaje() {
        return contenidoMensaje;
    }

    public void setContenidoMensaje(String contenidoMensaje) {
        this.contenidoMensaje = contenidoMensaje;
    }

    public LocalDate getFechaMensaje() {
        return fechaMensaje;
    }

    public void setFechaMensaje(LocalDate fechaMensaje) {
        this.fechaMensaje = fechaMensaje;
    }

    public Usuario getIdUsuarioManager() {
        return idUsuarioManager;
    }

    public void setIdUsuarioManager(Usuario idUsuarioManager) {
        this.idUsuarioManager = idUsuarioManager;
    }

    public Usuario getIdUsuarioTalento() {
        return idUsuarioTalento;
    }

    public void setIdUsuarioTalento(Usuario idUsuarioTalento) {
        this.idUsuarioTalento = idUsuarioTalento;
    }

    public Banda getBanda() {
        return banda;
    }

    public void setBanda(Banda banda) {
        this.banda = banda;
    }
}
