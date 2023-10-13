package org.example;
import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.util.*;

@XStreamAlias("ListaViajes")



public class ListaViajes {


        private List<Viaje> lista;
        public ListaViajes(){
            this.lista=new ArrayList<>();
        }
        public void add(Viaje viaje){
            this.lista.add(viaje);
        }

        public List<Viaje> getViajes(){
            return this.lista;
        }
    }


