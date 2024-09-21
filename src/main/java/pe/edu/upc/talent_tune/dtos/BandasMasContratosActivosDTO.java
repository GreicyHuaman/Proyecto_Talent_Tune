package pe.edu.upc.talent_tune.dtos;

public class BandasMasContratosActivosDTO {
    public String nombreBanda;
    public int contratosActivos;

    public String getNombreBanda() {
        return nombreBanda;
    }

    public void setNombreBanda(String nombreBanda) {
        this.nombreBanda = nombreBanda;
    }

    public int getContratosActivos() {
        return contratosActivos;
    }

    public void setContratosActivos(int contratosActivos) {
        this.contratosActivos = contratosActivos;
    }
}
