package view;

import controller.TenistaControler;
import model.entity.Tenista;

import java.io.IOException;
import java.util.UUID;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        try {
            TenistaControler tenistaControler=new TenistaControler();
            UUID codigo = UUID.randomUUID();
            Tenista t1=new Tenista(codigo, "Francisco", "españa");
            TenistaControler.CrearTenista(t1);




        } catch (IOException e) {
            throw new RuntimeException(e);
        }



    }
}
