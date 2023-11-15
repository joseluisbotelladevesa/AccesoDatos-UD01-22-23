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
        System.out.println("Nombre del nuevo Sponsor: ");
        String nombre=sc.nextLine();
        System.out.println("Codigo Sponsor: ");
        int codigo = sc.nextInt();
        Sponsor s1=new Sponsor(codigo, nombre);
        sponsorControler.CrearSponsor(s1);
    }

    private static void MostrarSponsors() throws IOException, SQLException {
        SponsorControler sponsorControler = new SponsorControler();
        List<Sponsor> sponsors = sponsorControler.GetAllSponsors();

        if(sponsors != null) {
            for (Sponsor spon : sponsors) {
                System.out.println(spon);
            }
        }else{
            System.out.println("nulo");
        }
    }

    private static void EncontrarSponsor() throws IOException, SQLException {
        SponsorControler sponsorControler = new SponsorControler();

        MostrarSponsors();
        System.out.println("Escribeme el nombre del sponsor");
        String nombresponsor=sc.nextLine();
        int id = 0;
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

    private static void BorrarSponsor() throws IOException, SQLException {
        SponsorControler sponsorControler = new SponsorControler();
        System.out.println("Que sponsor quieres borrar");
        String nombresponsor = sc.nextLine();
        int id = 0;
        List<Sponsor> sponsors = sponsorControler.GetAllSponsors();

        if (sponsors != null) {
            for (Sponsor spon : sponsors) {
                if (nombresponsor.equals(spon.getNombre())) {
                    id = spon.getCodigo();
                }
            }
        }
            if (sponsorControler.Delete(id)) {
                System.out.println("Sponsor borrado");
            } else {
                System.out.println("Sponsor no borrado");
            }
        }


    private static void ModificarSponsor() throws IOException, SQLException {
        SponsorControler sponsorControler = new SponsorControler();
        System.out.println("Nombre del Sponsor que desea modificar: ");
        String nombresponsor=sc.nextLine();
        Sponsor s1 = null;
        List<Sponsor> sponsors = sponsorControler.GetAllSponsors();

        if(sponsors != null) {
            for (Sponsor spon : sponsors) {
                if (nombresponsor.equals(spon.getNombre())) {
                    s1= spon;
                }
            }
        }
        if(sponsorControler.UpdateSponsor(s1)){
            System.out.println("Sponsor actualizado");
        }
        else{
            System.out.println("Sponsor no actualizado");
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
            System.out.println("Tenista no encontrado");
        }
    }

    private static void EliminarTenista() throws IOException, SQLException {
        TenistaControler tenistaControler = new TenistaControler();
        System.out.println("Que tenista quieres borrar");
        String nombretenista = sc.nextLine();
        String id = null;
        List<Tenista> sponsors = tenistaControler.GetAllTenistas();

        if (sponsors != null) {
            for (Tenista teni : sponsors) {
                if (nombretenista.equals(teni.getNombre())) {
                    id = String.valueOf(teni.getCodigo());
                }
            }
        }
        if(tenistaControler.Delete(id)){
            System.out.println("Tenista borrado");
        }
        else{
            System.out.println("Tenista no borrado");
        }
    }

    private static void ModificarTenista() throws IOException, SQLException {
        TenistaControler tenistaControler = new TenistaControler();
        System.out.println("Nombre del tenista: ");
        System.out.println("Que tenista quieres borrar");
        String nombretenista = sc.nextLine();
        Tenista tenista=null;
        List<Tenista> sponsors = tenistaControler.GetAllTenistas();

        if (sponsors != null) {
            for (Tenista teni : sponsors) {
                if (nombretenista.equals(teni.getNombre())) {
                    tenista=teni;
                }
            }
        }
        if(tenistaControler.UpdateTenista(tenista)){
            System.out.println("Tenista actualizado");
        }
        else{
            System.out.println("Tenista no actualizado");
        }
    }

    private static void CrearContratoTenista() throws IOException {
        TenistaControler tenistaControler = new TenistaControler();
        System.out.println("Codigo tenista");
    }

    private static void AñadirTorneoGanado() throws IOException {
        TenistaControler tenistaControler = new TenistaControler();
        System.out.println("Codigo tenista que ha ganado un torneo: ");
        int codtenista = sc.nextInt();
        System.out.println("Codigo torneo que ha ganado: ");
        int codtorneo = sc.nextInt();
        List<Tenista> sponsors = tenistaControler.GetAllTenistas();

        if (sponsors != null) {
            for (Tenista teni : sponsors) {
                if (nombretenista.equals(teni.getNombre())) {
                    tenista = teni;
                }
            }

        }
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

    private static void EliminarTorneo() throws IOException, SQLException {
        TorneoControler torneoControler=new TorneoControler();
        System.out.println("Que torneo quieres borrar");
        String nombretenista = sc.nextLine();
        String id = null;
        List<Torneo> torneos = torneoControler.GetAllTorneos();

        if (torneos != null) {
            for (Torneo tor : torneos) {
                if (nombretenista.equals(tor.getNombre())) {
                    id = String.valueOf(tor.getCodigo());
                }
            }
        }
        if(torneoControler.Delete(id)){
            System.out.println("Producto borrado");
        }
        else{
            System.out.println("Producto no borrado");
        }
    }

    private static void ModificarTorneo() throws IOException, SQLException {
        TorneoControler torneoControler=new TorneoControler();
        System.out.println("Nombre del producto: ");
        System.out.println("Que torneo quieres borrar");
        String nombretenista = sc.nextLine();
        Torneo torneo = null;
        List<Torneo> torneos = torneoControler.GetAllTorneos();

        if (torneos != null) {
            for (Torneo tor : torneos) {
                if (nombretenista.equals(tor.getNombre())) {
                    torneo = tor;
                }
            }
        }
        if(torneoControler.UpdateTorneo(torneo)){
            System.out.println("Producto actualizado");
        }
        else{
            System.out.println("Producto no actualizado");
        }
    }

}
