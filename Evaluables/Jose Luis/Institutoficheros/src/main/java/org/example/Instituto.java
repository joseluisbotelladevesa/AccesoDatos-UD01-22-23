package org.example;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.util.List;

@XStreamAlias("instituto")
public class Instituto {
    private String nombre;
    private List<Persona> personas;

    public Instituto() {
    }

    public Instituto(String nombre, List<Persona> personas) {
        this.nombre = nombre;
        this.personas = personas;
    }

    public List<Persona> getPersonas() {
        return personas;
    }

    public void setPersonas(List<Persona> personas) {
        this.personas = personas;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Instituto{" +
                "nombre='" + nombre + '\'' +
                ", personas=" + personas +
                '}';
    }
}
