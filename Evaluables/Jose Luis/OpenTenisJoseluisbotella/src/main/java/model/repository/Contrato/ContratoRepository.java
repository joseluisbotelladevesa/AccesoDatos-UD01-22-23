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
    public void addContrato(Contrato contrato) {
        try {
            boolean result = false;


            conexion = DriverManager.getConnection(this.URL, this.USER, this.PASS);

            String query = "insert into contrato(codigo, fechaInicio, fechaFin, saldo, codSponsor) values(?, ?, ?, ?, ?);";


            PreparedStatement ps = conexion.prepareStatement(query);

            ps.setObject(1, contrato.getCodigo());
            ps.setDate(2, Date.valueOf(contrato.getFechaInicio()));
            ps.setString(3, String.valueOf(contrato.getFechaFin()));
            ps.setDouble(4, contrato.getSaldo());
            ps.setInt(2, contrato.getCodSponsor());

            // El primero devuelve true o false, el segundo cuantas cosas ha insertado
            // ps.execute();

            result = ps.executeUpdate() > 0;
            if (result){
                System.out.println("Contrato Creado");
            }else{
                System.out.println("Contrato no creado");
            }

        } catch (SQLException e) {
            System.out.println("Sql error: "+e.getMessage());
        }
    }
}
