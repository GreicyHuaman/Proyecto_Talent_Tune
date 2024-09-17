package pe.edu.upc.talent_tune.entities;

import jakarta.persistence.*;

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
    private Date fechaMensaje;

    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "idBanda")
    private Banda banda;

    public Mensaje() {
    }

    public Mensaje(int idMensaje, String contenidoMensaje, Date fechaMensaje, Usuario usuario, Banda banda) {
        this.idMensaje = idMensaje;
        this.contenidoMensaje = contenidoMensaje;
        this.fechaMensaje = fechaMensaje;
        this.usuario = usuario;
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

    public Date getFechaMensaje() {
        return fechaMensaje;
    }

    public void setFechaMensaje(Date fechaMensaje) {
        this.fechaMensaje = fechaMensaje;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Banda getBanda() {
        return banda;
    }

    public void setBanda(Banda banda) {
        this.banda = banda;
    }
}
