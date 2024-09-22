package pe.edu.upc.talent_tune.dtos;

public class UsuarioMasVisualizacionesDTO {

    private String nombre;
    private int visualizaciones;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getVisualizaciones() {
        return visualizaciones;
    }

    public void setVisualizaciones(int visualizaciones) {
        this.visualizaciones = visualizaciones;
    }
}
