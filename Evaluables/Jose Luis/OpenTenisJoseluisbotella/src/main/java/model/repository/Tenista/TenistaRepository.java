package model.repository.Tenista;

import model.entity.Sponsor;
import model.entity.Tenista;

import java.io.FileReader;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.UUID;

public class TenistaRepository implements ITenistaRepository {
    private static final String CONFIG_FILE = "src/main/resources/propiedades.properties";

    private Connection conexion;

    @Override
    public void Save(Tenista entity) {

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
        return false;
    }

    @Override
    public boolean Update(Tenista entity) {
        return false;
    }

}