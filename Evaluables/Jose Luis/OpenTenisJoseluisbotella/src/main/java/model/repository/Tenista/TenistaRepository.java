package model.repository.Tenista;

import model.entity.Sponsor;
import model.entity.Tenista;

import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.UUID;

public class TenistaRepository implements ITenistaRepository {
    private static final String CONFIG_FILE = "src/main/resources/propiedades.properties";
    private Connection conexion;

    private static String URL;
    private static String USER;
    private static String PASS;

    public TenistaRepository() throws IOException {
        Properties properties = new Properties();
        properties.load(new FileReader(CONFIG_FILE));

        this.URL = properties.getProperty("URL");
        this.USER = properties.getProperty("USER");
        this.PASS = properties.getProperty("PASS");

    }
    @Override
    public void Save(Tenista tenista) {
        Tenista tenista1;
        int idTenista = 0;
        try {
            boolean result = false;


            conexion = DriverManager.getConnection(URL, USER, PASS);

            String query = "insert into product(reference, price, category, name) values(?, ?, ?, ?);";

            PreparedStatement ps = conexion.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

            ps.setObject(1, tenista.getCodigo());
            ps.setString(2, tenista.getNombre());
            ps.setString(3, tenista.getNacionalidad());

            // El primero devuelve true o false, el segundo cuantas cosas ha insertado
            // ps.execute();

            result = ps.executeUpdate() > 0;

            if (result) {
                ResultSet keys = ps.getGeneratedKeys();
                keys.next();
                idTenista = keys.getInt(1);

            }
}
        catch(SQLException sqle){
                System.out.println("Error sql: " + sqle.getMessage());
                } catch(Exception ex){
                System.out.println("Error general: " + ex.getMessage());
                }
    }

    @Override
    public Tenista FindById(String codigo) throws SQLException {
        Tenista tenista = null;
        try {
            Properties properties = new Properties();
            properties.load(new FileReader(CONFIG_FILE));

            String query = "select * from product where id = ?";

            conexion = DriverManager.getConnection(properties.getProperty("URL"),
                    properties.getProperty("USER"), properties.getProperty("PASS"));

            PreparedStatement ps = conexion.prepareStatement(query);
            ps.setString(1, codigo);


            ResultSet resultado = ps.executeQuery();

            while ((resultado.next())) {
                tenista = new Tenista((UUID) resultado.getObject("codigo"),
                        resultado.getString("nombre"), resultado.getString("nacionalidad"));
            }

            conexion.close();
        } catch (SQLException s) {
            System.out.println("Error sql: " + s.getMessage());
            return tenista;
        } catch (Exception e) {
            return tenista;

        }
        return tenista;
    }

    @Override
    public List<Tenista> FindAll() throws SQLException {
        List<Tenista> tenista = null;
        try {
            tenista = new ArrayList<>();
            var properties = new Properties();
            properties.load(new FileReader(CONFIG_FILE));

            String query = "select * from category";

            conexion = DriverManager.getConnection(properties.getProperty("URL"),
                    properties.getProperty("USER"), properties.getProperty("PASS"));

            PreparedStatement ps = conexion.prepareStatement(query);
            ResultSet resultado = ps.executeQuery();

            while (resultado.next()) {
                tenista.add(new Tenista((UUID) resultado.getObject("codigo"),
                        resultado.getString("nombre"), resultado.getString("nacionalidad")));
            }
            conexion.close();

        } catch (SQLException ex) {
            return null;
        } catch (Exception ex) {
            System.out.println("no va");
        }

        return tenista;
    }

    @Override
    public boolean Delete(String id) {
        boolean result = false;
        try(Connection conexion = DriverManager.getConnection(URL, USER, PASS)){

            String query = "delete from product where id = ?;";

            PreparedStatement ps = conexion.prepareStatement(query);
            ps.setString(1, id);

            result = ps.executeUpdate() > 0;

        }catch (Exception ex){
            System.out.println("Error en borrado del producto" + ex.getMessage());
        }
        return result;
    }

    @Override
    public boolean Update(Tenista tenista) {
        boolean result = false;
        try{

            conexion = DriverManager.getConnection(URL, USER, PASS);

            String query = "update product set reference = ?, price = ?, category = ?, name = ?  where id = ?;";

            PreparedStatement ps = conexion.prepareStatement(query);
            ps.setObject(1, tenista.getCodigo());
            ps.setString(2, tenista.getNombre());
            ps.setString(3, tenista.getNacionalidad());

            result = ps.executeUpdate() > 0;

        }catch (Exception ex){
            System.out.println("Error en update product: " + ex.getMessage());
        }
        return result;
    }


}