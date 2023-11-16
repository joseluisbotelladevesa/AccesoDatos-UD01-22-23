package model.repository.Contrato;

import model.entity.Contrato;
import model.repository.Sponsor.ISponsorRepository;

import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.time.LocalDate;
import java.util.Properties;
import java.util.Scanner;
import java.util.UUID;

public class ContratoRepository implements IContratoRepository {
    private static final String CONFIG_FILE = "src/main/resources/propiedades.properties";
    private Connection conexion;
    static Scanner sc= new Scanner(System.in);
    private static String URL;
    private static String USER;
    private static String PASS;

    public ContratoRepository() throws IOException {
        Properties properties = new Properties();
        properties.load(new FileReader(CONFIG_FILE));

        this.URL = properties.getProperty("URL");
        this.USER = properties.getProperty("USER");
        this.PASS = properties.getProperty("PASS");

    }


    @Override
    public boolean addContrato(String codSponsor, String codTenista, LocalDate
            fechaInicio, LocalDate fechaFin, double saldo) {
        try {
            boolean result = false;


            conexion = DriverManager.getConnection(this.URL, this.USER, this.PASS);
            String query = "insert into contrato(codigo, fechaInicio, fechaFin, saldo, codSponsor) values(?, ?, ?, ?, ?);";

            UUID codContrato=UUID.randomUUID();
            PreparedStatement ps = conexion.prepareStatement(query);

            ps.setObject(1, codContrato);
            ps.setDate(2, Date.valueOf(fechaInicio));
            ps.setString(3, String.valueOf(fechaFin));
            ps.setDouble(4, saldo);
            ps.setInt(5, Integer.parseInt(codSponsor));



            // El primero devuelve true o false, el segundo cuantas cosas ha insertado
            // ps.execute();

            result = ps.executeUpdate() > 0;
            if (result){
                System.out.println("Contrato Creado");

                String query2 = "insert into tenistaContrato(codTenista, codContrato) values (?, ?)";

                PreparedStatement ps2 = conexion.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);


                ps2.setObject(1, UUID.fromString(codTenista));
                ps2.setObject(2, codContrato);


                result = ps.executeUpdate() > 0;
                if (result){
                    System.out.println("Contrato con el tenista Creado");
                }else{
                    System.out.println("Contrato con el tenista no creado");
                }

            }else{
                System.out.println("Contrato no creado");
            }

        } catch (SQLException e) {
            System.out.println("Sql error: "+e.getMessage());
        }
        return false;
    }
}
