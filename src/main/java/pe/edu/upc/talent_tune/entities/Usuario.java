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
<<<<<<< HEAD
    @Column(name = "username", nullable = false, length = 20)
    private String username;
    @Column(name = "password", nullable = false, length = 20)
    private String password;
    private Boolean enabled;
    @Column(name = "descripcion", length = 45)
    private String descripcion;
    @Column(name = "descripcion", length = 45)

=======
    @Column(name = "Username", nullable = false, length = 20)
    private String username;
    @Column(name = "Password", nullable = false, length = 20)
    private String password;
    @Column(name = "descripcion", length = 45)
    private String descripcion;
    @Column(name = "Enabled",nullable = false)
    private Boolean Enabled;
>>>>>>> 30cab398753d56d91870dfbcdf2fbe9abdcc3504
    //consultar
    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "idPersona")
    private Persona persona;

    @JsonIgnore
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
<<<<<<< HEAD
    @JoinColumn(name = "user_id")
    private List<Rol> roles;
=======
    @JoinColumn(name = "idUsuario")
    private List<Rol> rol;
>>>>>>> 30cab398753d56d91870dfbcdf2fbe9abdcc3504

    @ManyToOne
    @JoinColumn(name = "idEvento")
    private Evento evento;

    public Usuario() {
    }

    public Usuario(int idUsuario, String username, String password, String descripcion, Boolean enabled, Persona persona, List<Rol> rol, Evento evento) {
        this.idUsuario = idUsuario;
        this.username = username;
        this.password = password;
        this.descripcion = descripcion;
        Enabled = enabled;
        this.persona = persona;
        this.Rol = rol;
        this.evento = evento;
    }

    public int getIdPersona() {
        return idUsuario;
    }

    public void setIdPersona(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Boolean getEnabled() {
        return Enabled;
    }

    public void setEnabled(Boolean enabled) {
        Enabled = enabled;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public List<Rol> getRol() {
        return rol;
    }

    public void setRol(List<Rol> rol) {
        this.rol = rol;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

