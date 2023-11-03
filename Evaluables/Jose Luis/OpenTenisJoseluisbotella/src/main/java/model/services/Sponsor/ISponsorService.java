package model.services.Sponsor;

import model.entity.Sponsor;

import java.sql.SQLException;
import java.util.List;

public interface ISponsorService {

     List<Sponsor> FindAll() throws SQLException;
     boolean Save(Sponsor sponsor);
     Sponsor FindById(int id) throws SQLException;
     boolean Delete(int id);
     boolean Update(Sponsor sponsor);
}

