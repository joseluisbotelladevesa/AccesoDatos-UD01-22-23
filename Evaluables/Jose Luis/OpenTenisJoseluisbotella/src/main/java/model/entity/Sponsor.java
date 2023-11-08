package model.entity;

import java.util.UUID;

public class Sponsor {

    private UUID codigo;
    private String nombre;


    public Sponsor(UUID codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public UUID getCodigo() {

        return codigo;
    }

    public void setCodigo(UUID codigo) {

        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Sponsor{" +
                "codigo=" + codigo +
                ", nombre='" + nombre + '\'' +
                '}';
    }

}
