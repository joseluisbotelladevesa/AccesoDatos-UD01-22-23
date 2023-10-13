package org.example;

import com.thoughtworks.xstream.XStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        ListaCanciones lista=new ListaCanciones();
        lista.add(getCancion1());
        lista.add(getCancion2());

        GenerateXML(lista);
        ReadXML();
        System.out.println("XML generado correctamente");
    }



    public static Cancion getCancion1(){
        Discografica discografica= new Discografica("MTV", "1234", "America", 200000);
        Cancion cancion=new Cancion(1, "Porcelain", "Moby", 5, 2000, false, discografica);
        List<String>paises= List.of("España", "Francia", "Portugal");
        cancion.setPaises(paises);
        return cancion;
    }
    public static Cancion getCancion2(){
        Discografica discografica= new Discografica("VTM", "4321", "Espanya", 200000);
        Cancion cancion=new Cancion(1, "nombre", "David", 5, 2000, false, discografica);
        return cancion;
    }

    public static void GenerateXML(ListaCanciones lista) throws FileNotFoundException {
        XStream xstream=new XStream();

        xstream.processAnnotations(Cancion.class);
        xstream.processAnnotations(Discografica.class);
        xstream.processAnnotations(ListaCanciones.class);

        xstream.addImplicitCollection(ListaCanciones.class, "lista");

        xstream.toXML(lista, new FileOutputStream("src/main/resources/canciones.xml"));

    }

    public static void ReadXML() throws FileNotFoundException {
        XStream xStream=new XStream();

        xStream.processAnnotations(Cancion.class);
        xStream.processAnnotations(Discografica.class);
        xStream.processAnnotations(ListaCanciones.class);

        xStream.addImplicitCollection(ListaCanciones.class, "lista");

        xStream.allowTypes(new Class[] {
                org.example.Cancion.class,
                org.example.Discografica.class,
                org.example.ListaCanciones.class
        });
        ListaCanciones lista=(ListaCanciones) xStream.fromXML(new FileInputStream("src/main/resources/canciones.xml"));

        for (Cancion cancion: lista.getCanciones()
             ) {
            System.out.println(cancion);
        }
    }

}