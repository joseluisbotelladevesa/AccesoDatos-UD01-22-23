package org.example;

import com.thoughtworks.xstream.XStream;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;



// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws IOException {
        GenerateXML(manolo());






    }
    public static List<Viaje> manolo() throws IOException {

       List<Viaje> listaviajes = new ArrayList<Viaje>();

        File f = new File("src/main/resources/viajes.dat");
        if (f.exists()) {
            f.createNewFile();
        }
        Viaje viaje = null;
        try {
            FileInputStream fileinput = new FileInputStream(f);
            ObjectInputStream objectinput = new ObjectInputStream(fileinput);

            try {
                while (true) {
                    viaje = (Viaje) objectinput.readObject();
                    listaviajes.add(viaje);
                }
            } catch (ClassNotFoundException e) {
                objectinput.close();

                System.out.println("XML generado correctamente");
                throw new RuntimeException(e);
            }


        } catch (FileNotFoundException e) {

        } catch (IOException e) {

        }
        return listaviajes;
    }

    private static Viaje GetViaje() {

        Lugar lugar=new Lugar("Murcia", "España");
        Hotel hotel=new Hotel("NH", "calledavid", 200);
        List<String> puntosvisita=List.of("alicante", "valencia","elche");
        Etapa etapa = new Etapa(lugar, hotel, 1, puntosvisita );
        Viaje viaje = new Viaje(LocalDate.of(2024,07,20), LocalDate.of(2024,07,26), (List<Etapa>) etapa, lugar);

        return viaje;
    }
    private static Viaje GetViaje2() {

        Lugar lugar=new Lugar("Murcia", "España");
        Hotel hotel=new Hotel("NH", "calledavid", 200);
        List<String> puntosvisita=List.of("alicante", "valencia","elche");
        Etapa etapa = new Etapa(lugar, hotel, 1, puntosvisita );
        Viaje viaje = new Viaje(LocalDate.of(2024,07,20), LocalDate.of(2024,07,26), (List<Etapa>) etapa, lugar);

        return viaje;
    }






    public static void GenerateXML(List<Viaje> lista) throws FileNotFoundException {
        XStream xstream=new XStream();

        xstream.processAnnotations(Viaje.class);
        xstream.processAnnotations(Etapa.class);
        xstream.processAnnotations(Hotel.class);
        xstream.processAnnotations(Lugar.class);
        xstream.processAnnotations(ListaViajes.class);

        xstream.addImplicitCollection(ListaViajes.class, "lista");

        xstream.toXML(lista, new FileOutputStream("src/main/resources/viajes.xml"));

    }


}