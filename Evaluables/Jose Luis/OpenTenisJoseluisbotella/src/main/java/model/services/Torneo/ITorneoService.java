package model.services.Torneo;

import model.entity.Torneo;

import java.sql.SQLException;
import java.util.List;

public interface ITorneoService {
    public List<Torneo> FindAll() throws SQLException;
    public boolean Save(Torneo torneo);
    public Torneo FindById(int id) throws SQLException;
    public boolean Delete(int id);
    public boolean Update(Torneo torneo);

}
