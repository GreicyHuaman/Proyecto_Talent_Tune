package pe.edu.upc.talent_tune.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name="Banda")
public class Banda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idBanda;

    @Column(name = "nombreBanda", nullable = false, length = 50)
    private String nombreBanda;

    @Column(name = "fechaBanda", nullable = false)
    private LocalDate fechaBanda;

    public Banda() {
    }

    public Banda(int idBanda, String nombreBanda, LocalDate fechaBanda) {
        this.idBanda = idBanda;
        this.nombreBanda = nombreBanda;
        this.fechaBanda = fechaBanda;
    }

    public int getIdBanda() {
        return idBanda;
    }

    public void setIdBanda(int idBanda) {
        this.idBanda = idBanda;
    }

    public String getNombreBanda() {
        return nombreBanda;
    }

    public void setNombreBanda(String nombreBanda) {
        this.nombreBanda = nombreBanda;
    }

    public LocalDate getFechaBanda() {
        return fechaBanda;
    }

    public void setFechaBanda(LocalDate fechaBanda) {
        this.fechaBanda = fechaBanda;
    }
}
