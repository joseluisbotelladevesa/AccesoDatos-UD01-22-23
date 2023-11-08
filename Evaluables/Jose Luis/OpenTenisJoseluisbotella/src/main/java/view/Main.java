package view;

import controller.SponsorControler;
import controller.TenistaControler;
import controller.TorneoControler;
import model.entity.Sponsor;
import model.entity.Tenista;
import model.entity.Torneo;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        try {
                Menu menu = new Menu();
                int opcion;
                do {
                    menu.mostrar();
                    opcion = menu.leer();
                    switch (opcion) {
                        case 1:
                            sponsor();
                            break;
                        case 2:
                            tenista();
                            break;
                        case 3:
                            torneo();
                            break;
                        case 0:
                            System.out.println("Saliendo");
                            break;
                    }
                } while (opcion != 0);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    private static void sponsor() throws IOException, SQLException {
        Menu menu = new Menu();
        int opcion;
        do {
            menu.mostrarSponsor();
            opcion = menu.leermenu2();
            switch (opcion) {
                case 1:
                    CrearSponsor();
                    break;
                case 2:
                    MostrarSponsors();
                    break;
                case 3:
                    EncontrarSponsor();
                    break;
                case 4:
                    BorrarSponsor();
                    break;
                case 5:
                    ModificarSponsor();
                    break;
                case 0:
                    break;
            }
        } while (opcion != 0);
        
    }

    private static void CrearSponsor() throws IOException {
        SponsorControler sponsorControler = new SponsorControler();
        UUID codigo = UUID.randomUUID();
        Sponsor s1=new Sponsor(codigo, "Juanjo");
        sponsorControler.CrearSponsor(s1);
    }

    private static void MostrarSponsors() throws IOException, SQLException {
        SponsorControler sponsorControler = new SponsorControler();
        List<Sponsor> sponsors = sponsorControler.GetAllSponsors();

        if(sponsors != null) {
            for (Sponsor spon : sponsors) {
                System.out.println(spon);
            }
        }
    }

    private static void EncontrarSponsor() throws IOException, SQLException {
        SponsorControler sponsorControler = new SponsorControler();

        MostrarSponsors();
        System.out.println("Escribeme el nombre del sponsor");
        String nombresponsor=sc.nextLine();
        UUID id=null;
        List<Sponsor> sponsors = sponsorControler.GetAllSponsors();

        if(sponsors != null) {
            for (Sponsor spon : sponsors) {
                if (nombresponsor.equals(spon.getNombre())) {
                    id = spon.getCodigo();
                }
            }
        }

        Sponsor sponsor = sponsorControler.GetSponsorbyid(id);

        if(sponsor != null)
        {
            System.out.println(sponsor);
        }
        else {
            System.out.println("Sponsor no encontrado");
        }
    }

    private static void BorrarSponsor() throws IOException {
        SponsorControler sponsorControler = new SponsorControler();
        if(sponsorControler.Delete(t1)){
            System.out.println("Producto borrado");
        }
        else{
            System.out.println("Producto no borrado");
        }
    }

    private static void ModificarSponsor() throws IOException {
        SponsorControler sponsorControler = new SponsorControler();
        System.out.println("Nombre del producto: ");

        if(sponsorControler.UpdateSponsor(t1)){
            System.out.println("Producto actualizado");
        }
        else{
            System.out.println("Producto no actualizado");
        }
    }

    private static void tenista() throws IOException, SQLException {
        Menu menu = new Menu();
        int opcion;
        do {
            menu.mostrarTenista();
            opcion = menu.leermenu3();
            switch (opcion) {
                case 1:
                    CrearTenista();
                    break;
                case 2:
                    MostrarTenistas();
                    break;
                case 3:
                    EncontrarTenista();
                    break;
                case 4:
                    EliminarTenista();
                    break;
                case 5:
                    ModificarTenista();
                    break;
                case 6:
                    CrearContratoTenista();
                case 7:
                    AñadirTorneoGanado();
                case 0:
                    break;
            }
        } while (opcion != 0);
    }

    private static void CrearTenista() throws IOException {
        TenistaControler tenistaControler=new TenistaControler();
        UUID codigo = UUID.randomUUID();
        Tenista t1=new Tenista(codigo, "Francisco", "españa");
        tenistaControler.CrearTenista(t1);
    }

    private static void MostrarTenistas() throws IOException, SQLException {
        TenistaControler tenistaControler = new TenistaControler();

        List<Tenista> tenistas = tenistaControler.GetAllTenistas();

        if(tenistas != null) {
            for (Tenista tenis : tenistas) {
                System.out.println(tenis);
            }
        }
    }

    private static void EncontrarTenista() throws IOException, SQLException {
        TenistaControler tenistaControler = new TenistaControler();
        Tenista tenista = tenistaControler.GetTenistabyid("1");

        if(tenista != null)
        {
            System.out.println(tenista);
        }
        else {
            System.out.println("Producto no encontrado");
        }
    }

    private static void EliminarTenista() throws IOException {
        TenistaControler tenistaControler = new TenistaControler();
        if(tenistaControler.Delete(t1)){
            System.out.println("Producto borrado");
        }
        else{
            System.out.println("Producto no borrado");
        }
    }

    private static void ModificarTenista() throws IOException {
        TenistaControler tenistaControler = new TenistaControler();
        System.out.println("Nombre del producto: ");

        if(tenistaControler.UpdateTenista(t1)){
            System.out.println("Producto actualizado");
        }
        else{
            System.out.println("Producto no actualizado");
        }
    }

    private static void CrearContratoTenista() throws IOException {
        TenistaControler tenistaControler = new TenistaControler();
    }

    private static void AñadirTorneoGanado() throws IOException {
        TenistaControler tenistaControler = new TenistaControler();

    }

    private static void torneo() throws IOException, SQLException {
        Menu menu = new Menu();
        int opcion;
        do {
            menu.mostrarTorneo();
            opcion = menu.leermenu2();
            switch (opcion) {
                case 1:
                    NuevoTorneo();
                    break;
                case 2:
                    MostrarTorneos();
                    break;
                case 3:
                    EncontrarTorneos();
                    break;
                case 4:
                    EliminarTorneo();
                    break;
                case 5:
                    ModificarTorneo();
                    break;
                case 0:
                    break;
            }
        } while (opcion != 0);
    }

    private static void NuevoTorneo() throws IOException {
        TorneoControler torneoControler=new TorneoControler();
        UUID codigo = UUID.randomUUID();
        Torneo to1=new Torneo(codigo, "Champions", 40, 4000);
        torneoControler.CrearTorneo(to1);
    }

    private static void MostrarTorneos() throws SQLException, IOException {
        TorneoControler torneoControler=new TorneoControler();
        List<Torneo> torneos = torneoControler.GetAllTorneos();

        if(torneos != null) {
            for (Torneo tor : torneos) {
                System.out.println(tor);
            }
        }
    }

    private static void EncontrarTorneos() throws SQLException, IOException {
        TorneoControler torneoControler=new TorneoControler();
        Torneo torneo = torneoControler.GetTorneobyid("1");

        if(torneo != null)
        {
            System.out.println(torneo);
        }
        else {
            System.out.println("Producto no encontrado");
        }
    }

    private static void EliminarTorneo() throws IOException {
        TorneoControler torneoControler=new TorneoControler();
        if(torneoControler.Delete(t1)){
            System.out.println("Producto borrado");
        }
        else{
            System.out.println("Producto no borrado");
        }
    }

    private static void ModificarTorneo() throws IOException {
        TorneoControler torneoControler=new TorneoControler();
        System.out.println("Nombre del producto: ");

        if(torneoControler.UpdateTorneo(t1)){
            System.out.println("Producto actualizado");
        }
        else{
            System.out.println("Producto no actualizado");
        }
    }

}
