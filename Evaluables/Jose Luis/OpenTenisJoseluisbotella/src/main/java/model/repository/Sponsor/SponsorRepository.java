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

            String query = "insert into product(reference, price, category, name) values(?, ?, ?, ?);";

            PreparedStatement ps = conexion.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

            ps.setObject(1, sponsor.getCodigo());
            ps.setString(2, sponsor.getNombre());

            // El primero devuelve true o false, el segundo cuantas cosas ha insertado
            // ps.execute();

            result = ps.executeUpdate() > 0;

            if (result) {
                ResultSet keys = ps.getGeneratedKeys();
                keys.next();
                idTenista = keys.getInt(1);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Sponsor FindById(UUID codigo) throws SQLException {
        Sponsor sponsor=null;
        try{
            Properties properties= new Properties();
            properties.load(new FileReader(CONFIG_FILE));

            String query = "select * from product where id = ?";

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

            String query= "select * from category";

            conexion = DriverManager.getConnection(properties.getProperty("URL"),
                    properties.getProperty("USER"), properties.getProperty("PASS"));

            PreparedStatement ps =conexion.prepareStatement(query);
            ResultSet resultado=ps.executeQuery();

            UUID codigo = UUID.randomUUID();

            while (resultado.next()){
                categorias.add(new Sponsor((UUID) resultado.getObject(String.valueOf(codigo)),
                        resultado.getString("name")));
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

            String query = "delete from product where id = ?;";

            PreparedStatement ps = conexion.prepareStatement(query);
            ps.setObject(1, id);

            result = ps.executeUpdate() > 0;

        }catch (Exception ex){
            System.out.println("Error en borrado del producto" + ex.getMessage());
        }
        return result;
    }

    @Override
    public boolean Update(Sponsor sponsor) {
        boolean result = false;
        try{

            conexion = DriverManager.getConnection(URL, USER, PASS);

            String query = "update product set reference = ?, price = ?, category = ?, name = ?  where id = ?;";

            PreparedStatement ps = conexion.prepareStatement(query);
            ps.setObject(1, sponsor.getCodigo());
            ps.setString(2, sponsor.getNombre());

            result = ps.executeUpdate() > 0;

        }catch (Exception ex){
            System.out.println("Error en update product: " + ex.getMessage());
        }
        return result;
    }


}

