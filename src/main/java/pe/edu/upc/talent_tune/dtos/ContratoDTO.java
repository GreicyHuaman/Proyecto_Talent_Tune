package pe.edu.upc.talent_tune.dtos;

import pe.edu.upc.talent_tune.entities.Banda;
import pe.edu.upc.talent_tune.entities.Usuario;

import java.util.Date;

public class ContratoDTO {

    private int idContrato;

    private String acuerdoContrato;

    private Date fechaContrato;

    private String duracionContrato;

    private double salarioContrato;

    private Usuario usuario;

    private Banda banda;

    public int getIdContrato() {
        return idContrato;
    }

    public void setIdContrato(int idContrato) {
        this.idContrato = idContrato;
    }

    public String getAcuerdoContrato() {
        return acuerdoContrato;
    }

    public void setAcuerdoContrato(String acuerdoContrato) {
        this.acuerdoContrato = acuerdoContrato;
    }

    public Date getFechaContrato() {
        return fechaContrato;
    }

    public void setFechaContrato(Date fechaContrato) {
        this.fechaContrato = fechaContrato;
    }

    public String getDuracionContrato() {
        return duracionContrato;
    }

    public void setDuracionContrato(String duracionContrato) {
        this.duracionContrato = duracionContrato;
    }

    public double getSalarioContrato() {
        return salarioContrato;
    }

    public void setSalarioContrato(double salarioContrato) {
        this.salarioContrato = salarioContrato;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Banda getBanda() {
        return banda;
    }

    public void setBanda(Banda banda) {
        this.banda = banda;
    }
}
