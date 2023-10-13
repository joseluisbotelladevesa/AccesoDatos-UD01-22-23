package org.example;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.util.ArrayList;
import java.util.List;
@XStreamAlias("institutos")

    public class ListaInstituto {


        private List<Instituto> lista;
        public ListaInstituto(){
            this.lista=new ArrayList<>();
        }
        public void add(Instituto instituto){
            this.lista.add(instituto);
        }

        public List<Instituto> getInstituto(){
            return this.lista;
        }
    }

