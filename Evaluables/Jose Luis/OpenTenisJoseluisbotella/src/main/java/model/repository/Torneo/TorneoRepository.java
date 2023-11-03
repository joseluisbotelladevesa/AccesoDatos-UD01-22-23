package model.repository.Torneo;

import model.entity.Sponsor;
import model.entity.Tenista;
import model.entity.Torneo;

import java.io.FileReader;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.UUID;

public class TorneoRepository implements ITorneoRepository{
    private static final String CONFIG_FILE = "src/main/resources/propiedades.properties";

    private Connection conexion;

    @Override
    public void Save(Torneo entity) {

    }

    @Override
    public Torneo FindById(String codigo) throws SQLException {
        Torneo torneo = null;
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

            String query = "select * from category";

            conexion = DriverManager.getConnection(properties.getProperty("URL"),
                    properties.getProperty("USER"), properties.getProperty("PASS"));

            PreparedStatement ps = conexion.prepareStatement(query);
            ResultSet resultado = ps.executeQuery();

            while (resultado.next()) {
                torneo.add( new Torneo((UUID) resultado.getObject("codigo"),
                        resultado.getString("nombre"),
                        resultado.getInt("puntos"),
                        resultado.getDouble("premio"));
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
        return false;
    }

    @Override
    public boolean Update(Torneo entity) {
        return false;
    }
}
