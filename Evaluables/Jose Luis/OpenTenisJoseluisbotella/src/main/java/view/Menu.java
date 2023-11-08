package view;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Menu {

    private int opcion;

    public void mostrar() {
        System.out.println(" 1. Nuevo Sponsor");
        System.out.println(" 2. Nuevo Tenista");
        System.out.println(" 3. Nuevo Torneo");
        System.out.println(" 0. FIN");
    }

    public int leer() {
        Scanner sc = new Scanner(System.in);
        do {
            System.out.print("Introduzca opción: ");
            opcion = sc.nextInt();
        } while (opcion < 0 || opcion > 3);
        sc.nextLine(); //limpiar el intro
        return opcion;
    }



    public void mostrarSponsor() {
        System.out.println(" 1. Crear Sponsor");
        System.out.println(" 2. Mostrar Sponsors");
        System.out.println(" 3. Encontrar Sponsor");
        System.out.println(" 4. Borrar Sponsor");
        System.out.println(" 5. Modificar Sponsor");
        System.out.println(" 0. FIN");
    }
    public void mostrarTenista() {
        System.out.println(" 1. Crear Tenista");
        System.out.println(" 2. Mostrar Tenistas");
        System.out.println(" 3. Encontrar Tenista");
        System.out.println(" 4. Eliminar Tenista");
        System.out.println(" 5. Modificar Tenista");
        System.out.println(" 6. Crear Contrato asociado a un tenista");
        System.out.println(" 7. Añadir Torneo Ganado");
        System.out.println(" 0. FIN");
    }public void mostrarTorneo() {
        System.out.println(" 1. Nuevo Torneo");
        System.out.println(" 2. Mostrar Torneos");
        System.out.println(" 3. Encontrar Torneos");
        System.out.println(" 4. Eliminar Torneo");
        System.out.println(" 5. Modificar Torneo");
        System.out.println(" 0. FIN");
    }

    public int leermenu2() {
        Scanner sc = new Scanner(System.in);
        do {
            System.out.print("Introduzca opción: ");
            opcion = sc.nextInt();
        } while (opcion < 0 || opcion > 5);
        sc.nextLine(); //limpiar el intro
        return opcion;
    }
    public int leermenu3() {
        Scanner sc = new Scanner(System.in);
        do {
            System.out.print("Introduzca opción: ");
            opcion = sc.nextInt();
        } while (opcion < 0 || opcion > 7);
        sc.nextLine(); //limpiar el intro
        return opcion;
    }
}
