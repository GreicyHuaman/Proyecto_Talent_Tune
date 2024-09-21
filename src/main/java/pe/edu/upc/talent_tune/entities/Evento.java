package pe.edu.upc.talent_tune.entities;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "Evento")
public class Evento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEvento;
    @Column(name = "nombreEvento", nullable = false, length = 30)
    private String nombreEvento;
    @Column(name = "fechaEvento", nullable = false)
    private LocalDate fechaEvento;
    @Column(name = "descripcionEvento", length = 50)
    private String descripcionEvento;

    @ManyToOne
    @JoinColumn(name = "idCategoria")
    private Categoria categoria;

    public Evento() {
    }

    public Evento(int idEvento, String nombreEvento, LocalDate fechaEvento, String descripcionEvento, Categoria categoria) {
        this.idEvento = idEvento;
        this.nombreEvento = nombreEvento;
        this.fechaEvento = fechaEvento;
        this.descripcionEvento = descripcionEvento;
        this.categoria = categoria;
    }

    public int getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(int idEvento) {
        this.idEvento = idEvento;
    }

    public String getNombreEvento() {
        return nombreEvento;
    }

    public void setNombreEvento(String nombreEvento) {
        this.nombreEvento = nombreEvento;
    }

    public Date getFechaEvento() {
        return fechaEvento;
    }

    public void setFechaEvento(Date fechaEvento) {
        this.fechaEvento = fechaEvento;
    }

    public String getDescripcionEvento() {
        return descripcionEvento;
    }

    public void setDescripcionEvento(String descripcionEvento) {
        this.descripcionEvento = descripcionEvento;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
