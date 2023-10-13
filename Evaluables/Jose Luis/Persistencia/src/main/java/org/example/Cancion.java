package org.example;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

import java.util.ArrayList;
import java.util.List;

@XStreamAlias("cancion")
public class Cancion {
    private int numero;
    private String nombre;
    private String autor;
    private int duracion;
    private int anyo;
    private boolean single;

    private Discografica discografica;
    @XStreamImplicit(itemFieldName="paises")
    private List<String>paises;
    public Cancion() {
    }

    public Cancion(int numero, String nombre, String autor, int duracion, int anyo, boolean single, Discografica discografica) {
        this.numero = numero;
        this.nombre = nombre;
        this.autor = autor;
        this.duracion = duracion;
        this.anyo = anyo;
        this.single = single;
        this.discografica= discografica;
        this.paises=new ArrayList<>();
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public int getAnyo() {
        return anyo;
    }

    public void setAnyo(int anyo) {
        this.anyo = anyo;
    }

    public boolean isSingle() {
        return single;
    }

    public void setSingle(boolean single) {
        this.single = single;
    }

    public Discografica getDiscografica() {
        return discografica;
    }

    public void setDiscografica(Discografica discografica) {
        this.discografica = discografica;
    }

    public List<String> getPaises() {
        return paises;
    }

    public void setPaises(List<String> paises) {
        this.paises = paises;
    }

    @Override
    public String toString() {
        return "Cancion{" +
                "numero=" + numero +
                ", nombre='" + nombre + '\'' +
                ", autor='" + autor + '\'' +
                ", duracion=" + duracion +
                ", anyo=" + anyo +
                ", single=" + single +
                ", discografica=" + discografica +
                ", paises=" + paises +
                '}';
    }
}
