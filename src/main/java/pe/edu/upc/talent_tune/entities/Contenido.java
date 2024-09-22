package pe.edu.upc.talent_tune.entities;


import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name="Contenido")
public class Contenido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idContenido;

    @Column(name = "tipoContenido", nullable = false, length = 40)
    private String tipoContenido;

    @Column(name = "titulo", nullable = false, length = 40)
    private String titulo;

    @Column(name = "fechaContenido", nullable = false)
    private LocalDate fecha;

    @Column(name = "visualizaciones", nullable = false)
    private int visualizaciones;

    @ManyToOne
    @JoinColumn(name="idCategoria")
    private Categoria idCategoria;

    @ManyToOne
    @JoinColumn(name="usuario")
    private Usuario usuario;

    public Contenido() {
    }

    public Contenido(int idContenido, String tipoContenido, String titulo, LocalDate fecha, int visualizaciones, Categoria idCategoria, Usuario usuario) {
        this.idContenido = idContenido;
        this.tipoContenido = tipoContenido;
        this.titulo = titulo;
        this.fecha = fecha;
        this.visualizaciones = visualizaciones;
        this.idCategoria = idCategoria;
        this.usuario = usuario;
    }

    public int getIdContenido() {
        return idContenido;
    }

    public void setIdContenido(int idContenido) {
        this.idContenido = idContenido;
    }

    public String getTipoContenido() {
        return tipoContenido;
    }

    public void setTipoContenido(String tipoContenido) {
        this.tipoContenido = tipoContenido;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public int getVisualizaciones() {
        return visualizaciones;
    }

    public void setVisualizaciones(int visualizaciones) {
        this.visualizaciones = visualizaciones;
    }

    public Categoria getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Categoria idCategoria) {
        this.idCategoria = idCategoria;
    }

    public Usuario getusuario() {
        return usuario;
    }

    public void setusuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
