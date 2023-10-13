package org.example;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.time.LocalDate;
@XStreamAlias("administrativo")
public class Administrativo extends Persona{
    private int tiempoContrato;

    public Administrativo(int tiempoContrato) {
        this.tiempoContrato = tiempoContrato;
    }

    public Administrativo(String dni, String nombre, String apellido1, String apellido2, LocalDate fechaNacimiento, Double sueldoBruto, int tiempoContrato) {
        super(dni, nombre, apellido1, apellido2, fechaNacimiento, sueldoBruto);
        this.tiempoContrato = tiempoContrato;

    }

    public int getTiempoContrato() {
        return tiempoContrato;
    }

    public void setTiempoContrato(int tiempoContrato) {
        this.tiempoContrato = tiempoContrato;
    }

    @Override
    public String toString() {
        return "Administrativo{" +
                "tiempoContrato=" + tiempoContrato +
                '}';
    }
}
