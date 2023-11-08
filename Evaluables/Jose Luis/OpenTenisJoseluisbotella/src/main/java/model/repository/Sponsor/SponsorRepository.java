package model.repository.Sponsor;

import model.entity.Sponsor;

import java.io.FileReader;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class SponsorRepository implements ISponsorRepository{
    private static final String CONFIG_FILE = "src/main/resources/propiedades.properties";

    private Connection conexion;

    @Override
    public void Save(Sponsor entity) {

    }

    @Override
    public Sponsor FindById(Integer codigo) throws SQLException {
        Sponsor sponsor=null;
        try{
            Properties properties= new Properties();
            properties.load(new FileReader(CONFIG_FILE));

            String query = "select * from product where id = ?";

            conexion = DriverManager.getConnection(properties.getProperty("URL"),
                    properties.getProperty("USER"), properties.getProperty("PASS"));

            PreparedStatement ps =conexion.prepareStatement(query);
            ps.setInt(1, codigo);



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
    public boolean Delete(Integer id) {
        return false;
    }

    @Override
    public boolean Update(Sponsor entity) {
        return false;
    }


}

