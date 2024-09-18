package pe.edu.upc.talent_tune.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "Usuario")
public class Usuario implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUsuario;
    @Column(name = "nombreUsuario", nullable = false, length = 20)
    private String nombreUsuario;
    @Column(name = "contrasenia", nullable = false, length = 20)
    private String contrasenia;
    private Boolean enabled;
    @Column(name = "descripcion", length = 45)
    private String descripcion;
    @Column(name = "descripcion", length = 45)

    //consultar
    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "idPersona")
    private Persona persona;

    @ManyToOne
    @JoinColumn(name = "idRol")
    private Rol roles;
    @ManyToOne
    @JoinColumn(name = "idEvento")
    private Evento evento;

    public Usuario() {
    }

    public Usuario(int idUsuario, String nombreUsuario, String contrasenia, String descripcion, Persona persona, Rol rol, Evento evento) {
        this.idUsuario = idUsuario;
        this.nombreUsuario = nombreUsuario;
        this.contrasenia = contrasenia;
        this.descripcion = descripcion;
        this.persona = persona;
        this.rol = rol;
        this.evento = evento;
    }

    public int getIdPersona() {
        return idUsuario;
    }

    public void setIdPersona(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Rol getroles() {
        return roles;
    }

    public void setroles(Rol rol) {
        this.roles = rol;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

}
