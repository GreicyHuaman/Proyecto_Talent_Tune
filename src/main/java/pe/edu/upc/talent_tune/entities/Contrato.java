package pe.edu.upc.talent_tune.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "Contrato")
public class Contrato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idContrato;

    @Column(name = "acuerdoContrato", nullable = false, length = 30)
    private String acuerdoContrato;

    @Column(name = "fechaContrato", nullable = false, length = 30)
    private Date fechaContrato;

    @Column(name = "duracionContrato", nullable = false, length = 30)
    private String duracionContrato;

    @Column(name = "salarioContrato", nullable = false)
    private double salarioContrato;

    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "idBanda")
    private Banda banda;

    public Contrato() {
    }

    public Contrato(int idContrato, String acuerdoContrato, Date fechaContrato, String duracionContrato, double salarioContrato, Usuario usuario, Banda banda) {
        this.idContrato = idContrato;
        this.acuerdoContrato = acuerdoContrato;
        this.fechaContrato = fechaContrato;
        this.duracionContrato = duracionContrato;
        this.salarioContrato = salarioContrato;
        this.usuario = usuario;
        this.banda = banda;
    }

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
