package model.repository.Torneo;

import model.entity.Sponsor;
import model.entity.Tenista;
import model.entity.Torneo;

import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.UUID;

public class TorneoRepository implements ITorneoRepository{
    private static final String CONFIG_FILE = "src/main/resources/propiedades.properties";
    private Connection conexion;

    private static String URL;
    private static String USER;
    private static String PASS;

    public TorneoRepository() throws IOException {
        Properties properties = new Properties();
        properties.load(new FileReader(CONFIG_FILE));

        this.URL = properties.getProperty("URL");
        this.USER = properties.getProperty("USER");
        this.PASS = properties.getProperty("PASS");

    }

    @Override
    public void Save(Torneo torneo) {
        Tenista tenista1;
        int idTenista = 0;
        try {
            boolean result = false;


            conexion = DriverManager.getConnection(this.URL, this.USER, this.PASS);

            String query = "insert into torneo(codigo, nombre, puntos, premio) values(?, ?, ?, ?);";

            PreparedStatement ps = conexion.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

            ps.setObject(1, torneo.getCodigo());
            ps.setString(2, torneo.getNombre());
            ps.setInt(3, torneo.getPuntos());
            ps.setDouble(4, torneo.getPuntos());

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
    public Torneo FindById(String codigo) throws SQLException {
        Torneo torneo = null;
        try {
            Properties properties = new Properties();
            properties.load(new FileReader(CONFIG_FILE));

            String query = "select * from product where codigo = ?";

            conexion = DriverManager.getConnection(properties.getProperty("URL"),
                    properties.getProperty("USER"), properties.getProperty("PASS"));

            PreparedStatement ps = conexion.prepareStatement(query);
            ps.setString(1, codigo);


            ResultSet resultado = ps.executeQuery();

            while ((resultado.next())) {
                torneo = new Torneo((UUID) resultado.getObject("codigo"),
                        resultado.getString("nombre"),
                        resultado.getInt("puntos"),
                        resultado.getDouble("premio"));
            }

            conexion.close();
        } catch (SQLException s) {
            System.out.println("Error sql: " + s.getMessage());
            return torneo;
        } catch (Exception e) {
            return torneo;

        }
        return torneo;
    }

    @Override
    public List<Torneo> FindAll() throws SQLException {
        List<Torneo> torneo = null;
        try {
            torneo = new ArrayList<>();
            var properties = new Properties();
            properties.load(new FileReader(CONFIG_FILE));

            String query = "select * from torneo";

            conexion = DriverManager.getConnection(properties.getProperty("URL"),
                    properties.getProperty("USER"), properties.getProperty("PASS"));

            PreparedStatement ps = conexion.prepareStatement(query);
            ResultSet resultado = ps.executeQuery();

            while (resultado.next()) {
                torneo.add( new Torneo((UUID) resultado.getObject("codigo"),
                        resultado.getString("nombre"),
                        resultado.getInt("puntos"),
                        resultado.getDouble("premio")));
            }
            conexion.close();

        } catch (SQLException ex) {
            return null;
        } catch (Exception ex) {
            System.out.println("no va");
        }

        return torneo;
    }

    @Override
    public boolean Delete(String id) {

        boolean result = false;
        try(Connection conexion = DriverManager.getConnection(URL, USER, PASS)){

            String query = "delete from product where codigo = ?;";

            PreparedStatement ps = conexion.prepareStatement(query);
            ps.setString(1, id);

            result = ps.executeUpdate() > 0;

        }catch (Exception ex){
            System.out.println("Error en borrado del torneo" + ex.getMessage());
        }
        return result;
    }

    @Override
    public boolean Update(Torneo torneo) {
        boolean result = false;
        try{

            conexion = DriverManager.getConnection(URL, USER, PASS);

            String query = "update product set reference = ?, price = ?, category = ?, name = ?  where id = ?;";

            PreparedStatement ps = conexion.prepareStatement(query);
            ps.setObject(1, torneo.getCodigo());
            ps.setString(2, torneo.getNombre());
            ps.setInt(3, torneo.getPuntos());
            ps.setDouble(4, torneo.getPremio());


            result = ps.executeUpdate() > 0;

        }catch (Exception ex){
            System.out.println("Error en update torneo: " + ex.getMessage());
        }
        return result;
    }
}
