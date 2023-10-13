package org.example;

import com.thoughtworks.xstream.XStream;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws IOException {

        List<Instituto>listaInstitutos=null;


        try {
            manolo(ReadXML(listaInstitutos));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
    public static void manolo(List lista) throws IOException {

       // List<Instituto> listainstitutos = new ArrayList<Instituto>();

        File f = new File("src/main/resources/instituto.dat");
        if (f.exists()) {
            f.createNewFile();
        }

        try {
            Instituto instituto = new Instituto();
            FileOutputStream fileout = new FileOutputStream(f);
            ObjectOutputStream objectout = new ObjectOutputStream(fileout);



                      objectout.writeObject(instituto);

                  objectout.close();

        } catch (FileNotFoundException e) {

        } catch (IOException e) {

        }
    }

    public static List ReadXML(List<Instituto>listaInsitutos) throws FileNotFoundException {
        XStream xStream=new XStream();

        xStream.processAnnotations(Instituto.class);
        xStream.processAnnotations(Administrativo.class);
        xStream.processAnnotations(Profesor.class);
        xStream.processAnnotations(Falta.class);
        xStream.processAnnotations(Historial.class);

        xStream.processAnnotations(ListaInstituto.class);

        xStream.addImplicitCollection(ListaInstituto.class, "lista");

        xStream.allowTypes(new Class[] {
                org.example.Instituto.class,
                org.example.Administrativo.class,
                org.example.Persona.class,
                org.example.Profesor.class,
                org.example.Falta.class,
                org.example.Historial.class,
                org.example.ListaInstituto.class
        });
        ListaInstituto lista=(ListaInstituto) xStream.fromXML(new FileInputStream("src/main/resources/instituto.xml"));

     /*   for (Instituto ins: lista.getClass()) {
            System.out.println(lista);
        }*/
        return (List) lista;
    }

}