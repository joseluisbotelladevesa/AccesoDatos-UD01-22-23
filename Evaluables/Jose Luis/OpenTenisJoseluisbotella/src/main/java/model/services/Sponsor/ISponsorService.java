package model.services.Sponsor;

import model.entity.Sponsor;

import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

public interface ISponsorService {

     List<Sponsor> FindAll() throws SQLException;
     void Save(Sponsor sponsor);
     Sponsor FindById(UUID codigo) throws SQLException;
     boolean Delete(UUID id);
     boolean Update(Sponsor sponsor);
}

