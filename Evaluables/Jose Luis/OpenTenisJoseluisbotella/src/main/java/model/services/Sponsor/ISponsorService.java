package model.services.Sponsor;

import model.entity.Sponsor;

import java.sql.SQLException;
import java.util.List;

public interface ISponsorService {

     List<Sponsor> FindAll() throws SQLException;
     void Save(Sponsor sponsor);
     Sponsor FindById(Integer codigo) throws SQLException;
     boolean Delete(Integer id);
     boolean Update(Sponsor sponsor);
}

