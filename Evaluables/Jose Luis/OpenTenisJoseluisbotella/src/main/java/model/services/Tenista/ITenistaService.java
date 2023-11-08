package model.services.Tenista;

import model.entity.Tenista;

import java.sql.SQLException;
import java.util.List;

public interface ITenistaService {
    public List<Tenista> FindAll() throws SQLException;
    public void Save(Tenista tenista);
    public Tenista FindById(String id) throws SQLException;
    public boolean Delete(String id);
    public boolean Update(Tenista tenista);
}

