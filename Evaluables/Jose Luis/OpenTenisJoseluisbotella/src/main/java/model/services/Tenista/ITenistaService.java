package model.services.Tenista;

import model.entity.Tenista;

import java.sql.SQLException;
import java.util.List;

public interface ITenistaService {
    public List<Tenista> FindAll() throws SQLException;
    public boolean Save(Tenista tenista);
    public Tenista FindById(int id) throws SQLException;
    public boolean Delete(int id);
    public boolean Update(Tenista tenista);
}

}
