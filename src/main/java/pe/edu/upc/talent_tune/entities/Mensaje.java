package pe.edu.upc.talent_tune.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "Mensaje")
public class Mensaje {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idMensaje;

    @Column(name = "contenidoMensaje", nullable = false, length = 30)
    private String contenidoMensaje;

    @Column(name = "fechaMensaje", nullable = false, length = 30)
    private LocalDate fechaMensaje;

    @ManyToOne
    @JoinColumn(name = "idUsuarioManager")
    private Usuario idUsuarioManager;

    @ManyToOne
    @JoinColumn(name = "idUsuarioTalento")
    private Usuario idUsuarioTalento;

    @ManyToOne
    @JoinColumn(name = "idBanda")
    private Banda banda;

    public Mensaje() {
    }

    public Mensaje(int idMensaje, String contenidoMensaje, LocalDate fechaMensaje, Usuario idUsuarioManager, Usuario idUsuarioTalento, Banda banda) {
        this.idMensaje = idMensaje;
        this.contenidoMensaje = contenidoMensaje;
        this.fechaMensaje = fechaMensaje;
        this.idUsuarioManager = idUsuarioManager;
        this.idUsuarioTalento = idUsuarioTalento;
        this.banda = banda;
    }

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
