package model.services.Torneo;

import model.entity.Torneo;

import java.sql.SQLException;
import java.util.List;

public interface ITorneoService {
    public List<Torneo> FindAll() throws SQLException;
    public void Save(Torneo torneo);
    public Torneo FindById(String id) throws SQLException;
    public boolean Delete(String id);
    public boolean Update(Torneo torneo);

}
