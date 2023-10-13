package org.example;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.time.format.DateTimeFormatter;
@XStreamAlias("falta")
public class Falta {
    private DateTimeFormatter fecha;
    private String razon;

    public Falta(DateTimeFormatter fecha, String razon) {
        this.fecha = fecha;
        this.razon = razon;
    }

    public DateTimeFormatter getFecha() {
        return fecha;
    }

    public void setFecha(DateTimeFormatter fecha) {
        this.fecha = fecha;
    }

    public String getRazon() {
        return razon;
    }

    public void setRazon(String razon) {
        this.razon = razon;
    }

    @Override
    public String toString() {
        return "Falta{" +
                "fecha=" + fecha +
                ", razon='" + razon + '\'' +
                '}';
    }
}
