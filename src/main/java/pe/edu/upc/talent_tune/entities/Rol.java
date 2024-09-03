package pe.edu.upc.talent_tune.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Rol")
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idRol;
    @Column(name = "tipoRol", nullable = false, length = 20)
    private String tipoRol;
    @Column(name = "areaDestacada",length = 20)
    private String areaDestacada;
    @Column(name = "agencia",length = 20)
    private String agencia;

    @ManyToOne
    @JoinColumn(name = "idCategoria")
    private Categoria categoria;

    public Rol() {
    }

    public Rol(int idRol, String tipoRol, String areaDestacada, String agencia, Categoria categoria) {
        this.idRol = idRol;
        this.tipoRol = tipoRol;
        this.areaDestacada = areaDestacada;
        this.agencia = agencia;
        this.categoria = categoria;
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
}
