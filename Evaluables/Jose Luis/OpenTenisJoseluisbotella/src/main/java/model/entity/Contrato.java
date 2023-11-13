package model.entity;

import java.time.LocalDate;
import java.util.UUID;

public class Contrato {
    UUID codigo;
    LocalDate fechaInicio;
    LocalDate fechaFin;
    double saldo;
    int codSponsor;

    public Contrato(UUID codigo, LocalDate fechaInicio, LocalDate fechaFin, double saldo, int codSponsor) {
        this.codigo = codigo;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.saldo = saldo;
        this.codSponsor = codSponsor;
    }

    public Contrato() {
    }

    public UUID getCodigo() {
        return codigo;
    }

    public void setCodigo(UUID codigo) {
        this.codigo = codigo;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public int getCodSponsor() {
        return codSponsor;
    }

    public void setCodSponsor(int codSponsor) {
        this.codSponsor = codSponsor;
    }

    @Override
    public String toString() {
        return "Contrato{" +
                "codigo=" + codigo +
                ", fechaInicio=" + fechaInicio +
                ", fechaFin=" + fechaFin +
                ", saldo=" + saldo +
                ", codSponsor=" + codSponsor +
                '}';
    }
}
