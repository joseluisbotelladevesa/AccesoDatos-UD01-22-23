package model.repository.Torneo;

import model.entity.Sponsor;

import java.io.FileReader;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class TorneoRepository implements ITorneoRepository{
    private static final String CONFIG_FILE = "src/main/resources/propiedades.properties";

    private Connection conexion;

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

            while (resultado.next()){
                categorias.add(new Sponsor(resultado.getInt("id"),
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
    public Sponsor FindById(Integer id) throws SQLException {
        Sponsor sponsor=null;
        try{
            Properties properties= new Properties();
            properties.load(new FileReader(CONFIG_FILE));

            String query = "select * from product where id = ?";

            conexion = DriverManager.getConnection(properties.getProperty("URL"),
                    properties.getProperty("USER"), properties.getProperty("PASS"));

            PreparedStatement ps =conexion.prepareStatement(query);
            ps.setInt(1, id);



            ResultSet resultado=ps.executeQuery();

            while ((resultado.next())){
                sponsor=new Sponsor(resultado.getInt("id"),
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
    public boolean Save(Sponsor entity) {
        return false;
    }

    @Override
    public boolean Delete(Integer id) {
        return false;
    }

    @Override
    public boolean Update(Sponsor entity) {
        return false;
    }


}
}
