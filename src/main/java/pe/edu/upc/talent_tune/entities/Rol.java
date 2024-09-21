package pe.edu.upc.talent_tune.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;

@Entity
<<<<<<< HEAD
@Table(name = "Rol")
=======
@Table(name = "roles", uniqueConstraints = {@UniqueConstraint(columnNames = {"idUsuario","rol"})})
>>>>>>> 30cab398753d56d91870dfbcdf2fbe9abdcc3504
public class Rol implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idRol;
    @Column(name = "nombreRol", nullable = false, length = 100)
    private String nombreRol;
    @Column(name = "tipoRol", nullable = false, length = 20)
    private String tipoRol;
    @Column(name = "areaDestacada",length = 20)
    private String areaDestacada;
    @Column(name = "agencia",length = 20)
    private String agencia;

    @ManyToOne
    @JoinColumn(name = "idCategoria")
    private Categoria categoria;

<<<<<<< HEAD
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private Usuario usuario;
=======
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "idUsuario", nullable = false)
    private Usuario usuarios;
>>>>>>> 30cab398753d56d91870dfbcdf2fbe9abdcc3504

    public Rol() {
    }

    public Rol(int idRol, String tipoRol, String areaDestacada, String agencia, Categoria categoria, Usuario usuarios) {
        this.idRol = idRol;
        this.tipoRol = tipoRol;
        this.areaDestacada = areaDestacada;
        this.agencia = agencia;
        this.categoria = categoria;
        this.usuarios = usuarios;
    }

    public int getIdRol() {
        return idRol;
    }

    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }

    public String getTipoRol() {
        return tipoRol;
    }

    public void setTipoRol(String tipoRol) {
        this.tipoRol = tipoRol;
    }

    public String getAreaDestacada() {
        return areaDestacada;
    }

    public void setAreaDestacada(String areaDestacada) {
        this.areaDestacada = areaDestacada;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

<<<<<<< HEAD
    public String getNombreRol() {
        return nombreRol;
    }

    public void setNombreRol(String nombreRol) {
        this.nombreRol = nombreRol;
=======
    public Usuario getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Usuario usuarios) {
        this.usuarios = usuarios;
>>>>>>> 30cab398753d56d91870dfbcdf2fbe9abdcc3504
    }
}
