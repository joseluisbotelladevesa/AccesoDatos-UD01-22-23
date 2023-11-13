package model.repository.Sponsor;

import model.entity.Sponsor;
import model.entity.Tenista;

import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.UUID;

public class SponsorRepository implements ISponsorRepository{
    private static final String CONFIG_FILE = "src/main/resources/propiedades.properties";
    private Connection conexion;

    private static String URL;
    private static String USER;
    private static String PASS;

    public SponsorRepository() throws IOException {
        Properties properties = new Properties();
        properties.load(new FileReader(CONFIG_FILE));

        this.URL = properties.getProperty("URL");
        this.USER = properties.getProperty("USER");
        this.PASS = properties.getProperty("PASS");

    }

    @Override
    public void Save(Sponsor sponsor) {
        int idTenista = 0;
        try {
            boolean result = false;


            conexion = DriverManager.getConnection(this.URL, this.USER, this.PASS);

            String query = "insert into sponsor(codigo, nombre) values(?, ?);";

            PreparedStatement ps = conexion.prepareStatement(query);

            ps.setObject(1, sponsor.getCodigo());
            ps.setString(2, sponsor.getNombre());

            // El primero devuelve true o false, el segundo cuantas cosas ha insertado
            // ps.execute();

            result = ps.executeUpdate() > 0;
            if (result){
                System.out.println("Sponsor Creado");
            }else{
                System.out.println("Sponsor no creado");
            }

        } catch (SQLException e) {
            System.out.println("Sql error: "+e.getMessage());
            }
    }

    @Override
    public Sponsor FindById(UUID codigo) throws SQLException {
        Sponsor sponsor=null;
        try{
            Properties properties= new Properties();
            properties.load(new FileReader(CONFIG_FILE));

            String query = "select * from sponsor where codigo = ?";

            conexion = DriverManager.getConnection(properties.getProperty("URL"),
                    properties.getProperty("USER"), properties.getProperty("PASS"));
            codigo = UUID.randomUUID();

            PreparedStatement ps =conexion.prepareStatement(query);
            ps.setObject(1, codigo);    //no se si esta bien preguntar en clase a dani guapo



            ResultSet resultado=ps.executeQuery();

            while ((resultado.next())){
                sponsor=new Sponsor((UUID) resultado.getObject(String.valueOf(codigo)),
                        resultado.getString("name"));
            }

            conexion.close();
        }catch (SQLException s) {
            System.out.println("Error sql: " + s.getMessage());
            return sponsor;
        }catch (Exception e) {
            return sponsor;

        }
        return sponsor;
    }

    @Override
    public List<Sponsor> FindAll() throws SQLException {
        List<Sponsor>categorias = null;
        try {
            categorias=new ArrayList<>();
            var properties = new Properties();
            properties.load(new FileReader(CONFIG_FILE));

            String query= "select * from sponsor";

            conexion = DriverManager.getConnection(properties.getProperty("URL"),
                    properties.getProperty("USER"), properties.getProperty("PASS"));

            PreparedStatement ps =conexion.prepareStatement(query);
            ResultSet resultado=ps.executeQuery();

            while (resultado.next()){
                categorias.add(new Sponsor((UUID) resultado.getObject("codigo"),
                        resultado.getString("nombre")));
            }
            conexion.close();

        } catch (SQLException ex) {
            return null;
        }catch (Exception ex) {
            System.out.println("no va");
        }

        return categorias;
    }

    @Override
    public boolean Delete(UUID id) {
        boolean result = false;
        try(Connection conexion = DriverManager.getConnection(URL, USER, PASS)){

            String query = "delete from product where codigo = ?;";

            PreparedStatement ps = conexion.prepareStatement(query);
            ps.setObject(1, id);

            result = ps.executeUpdate() > 0;

        }catch (Exception ex){
            System.out.println("Error en borrado del sponsor" + ex.getMessage());
        }
        return result;
    }

    @Override
    public boolean Update(Sponsor sponsor) {
        boolean result = false;
        try{

            conexion = DriverManager.getConnection(URL, USER, PASS);

            String query = "update sponsor set codigo = ?, nombre = ?;";

            PreparedStatement ps = conexion.prepareStatement(query);
            ps.setObject(1, sponsor.getCodigo());
            ps.setString(2, sponsor.getNombre());

            result = ps.executeUpdate() > 0;

        }catch (Exception ex){
            System.out.println("Error en update sponsor: " + ex.getMessage());
        }
        return result;
    }


}

