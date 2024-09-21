package pe.edu.upc.talent_tune.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
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
    private LocalDate fechaContrato;

    @Column(name = "duracionContrato", nullable = false, length = 30)
    private String duracionContrato;

    @Column(name = "salarioContrato", nullable = false)
    private double salarioContrato;

    @Column(name = "estadoContrato", nullable = false)
    private String estadoContrato;

    @ManyToOne
    @JoinColumn(name = "idUsuarioManager")
    private Usuario idUsuarioManager;

    @ManyToOne
    @JoinColumn(name = "idUsuarioTalento")
    private Usuario idUsuarioTalento;

    @ManyToOne
    @JoinColumn(name = "idBanda")
    private Banda banda;

    public Contrato() {
    }

    public Contrato(int idContrato, String acuerdoContrato, LocalDate fechaContrato, String duracionContrato, double salarioContrato, String estadoContrato, Usuario idUsuarioManager, Usuario idUsuarioTalento, Banda banda) {
        this.idContrato = idContrato;
        this.acuerdoContrato = acuerdoContrato;
        this.fechaContrato = fechaContrato;
        this.duracionContrato = duracionContrato;
        this.salarioContrato = salarioContrato;
        this.estadoContrato = estadoContrato;
        this.idUsuarioManager = idUsuarioManager;
        this.idUsuarioTalento = idUsuarioTalento;
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

    public LocalDate getFechaContrato() {
        return fechaContrato;
    }

    public void setFechaContrato(LocalDate fechaContrato) {
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

    public String isEstadoContrato() {
        return estadoContrato;
    }

    public void setEstadoContrato(String estadoContrato) {
        this.estadoContrato = estadoContrato;
    }

    public Usuario getIdUsuarioManager() {
        return idUsuarioManager;
    }

    public void setIdUsuarioManager(Usuario idUsuarioManager) {
        this.idUsuarioManager = idUsuarioManager;
    }

    public Usuario getIdUsuarioTalento() {
        return idUsuarioTalento;
    }

    public void setIdUsuarioTalento(Usuario idUsuarioTalento) {
        this.idUsuarioTalento = idUsuarioTalento;
    }

    public Banda getBanda() {
        return banda;
    }

    public void setBanda(Banda banda) {
        this.banda = banda;
    }
}
