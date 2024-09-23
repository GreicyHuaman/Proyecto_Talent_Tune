package pe.edu.upc.talent_tune.dtos;

import java.time.LocalDate;


public class BandaDTO {

    private int idBanda;

    private String nombreBanda;

    private LocalDate fechaBanda;

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
