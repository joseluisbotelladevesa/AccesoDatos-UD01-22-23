package model.services.Sponsor;

import model.entity.Sponsor;

import java.sql.SQLException;
import java.util.List;

public interface ISponsorService {

    public List<Sponsor> FindAll() throws SQLException;
    public boolean Save(Sponsor sponsor);
    public Sponsor FindById(int id) throws SQLException;
    public boolean Delete(int id);
    public boolean Update(Sponsor sponsor);
}

