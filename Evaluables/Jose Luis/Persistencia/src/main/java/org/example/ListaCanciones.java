package org.example;
import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.util.*;

@XStreamAlias("canciones")
public class ListaCanciones {
    private List<Cancion>lista;
    public ListaCanciones(){
        this.lista=new ArrayList<>();
    }
    public void add(Cancion cancion){

        this.lista.add(cancion);
    }

    public List<Cancion> getCanciones(){
        return this.lista;
    }
}
