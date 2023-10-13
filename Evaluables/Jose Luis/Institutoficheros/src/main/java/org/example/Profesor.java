package org.example;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
@XStreamAlias("profesor")

public class Profesor extends Persona{
    private DateTimeFormatter fechaIncorporacion;
    private Historial historial;
    private Falta falta;

    public Profesor(DateTimeFormatter fechaIncorporacion) {
        this.fechaIncorporacion = fechaIncorporacion;
    }

    public Profesor(DateTimeFormatter fechaIncorporacion, Historial historial, Falta falta) {
        this.fechaIncorporacion = fechaIncorporacion;
        this.historial = historial;
        this.falta = falta;
    }

    public Profesor(String dni, String nombre, String apellido1, String apellido2, LocalDate fechaNacimiento, Double sueldoBruto, DateTimeFormatter fechaIncorporacion, Historial historial, Falta falta) {
        super(dni, nombre, apellido1, apellido2, fechaNacimiento, sueldoBruto);
        this.fechaIncorporacion = fechaIncorporacion;
        this.historial = historial;
        this.falta = falta;
    }

    public Profesor(String dni, String nombre, String apellido1, String apellido2, LocalDate fechaNacimiento, Double sueldoBruto, DateTimeFormatter fechaIncorporacion) {
        super(dni, nombre, apellido1, apellido2, fechaNacimiento, sueldoBruto);
        this.fechaIncorporacion = fechaIncorporacion;
    }

    public Falta getFalta() {
        return falta;
    }



    public void setFalta(Falta falta) {
        this.falta = falta;
    }

    public Profesor(DateTimeFormatter fechaIncorporacion, Historial historial) {
        this.fechaIncorporacion = fechaIncorporacion;
        this.historial = historial;
    }

    public Profesor(String dni, String nombre, String apellido1, String apellido2, LocalDate fechaNacimiento, Double sueldoBruto, DateTimeFormatter fechaIncorporacion, Historial historial) {
        super(dni, nombre, apellido1, apellido2, fechaNacimiento, sueldoBruto);
        this.fechaIncorporacion = fechaIncorporacion;
        this.historial = historial;
    }

    public DateTimeFormatter getFechaIncorporacion() {
        return fechaIncorporacion;
    }

    public void setFechaIncorporacion(DateTimeFormatter fechaIncorporacion) {
        this.fechaIncorporacion = fechaIncorporacion;
    }

    public Historial getHistorial() {
        return historial;
    }

    public void setHistorial(Historial historial) {
        this.historial = historial;
    }

    @Override
    public String toString() {
        return "Profesor{" +
                "fechaIncorporacion=" + fechaIncorporacion +
                ", historial=" + historial +
                ", falta=" + falta +
                '}';
    }
}
