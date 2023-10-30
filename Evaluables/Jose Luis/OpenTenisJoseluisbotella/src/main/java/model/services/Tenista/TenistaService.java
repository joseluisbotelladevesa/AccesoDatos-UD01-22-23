package model.services.Tenista;

import model.entity.Sponsor;
import model.entity.Tenista;
import model.repository.Sponsor.ISponsorRepository;
import model.repository.Sponsor.SponsorRepository;
import model.repository.Tenista.ITenistaRepository;
import model.repository.Tenista.TenistaRepository;

import java.sql.SQLException;
import java.util.List;

public class TenistaService {
    private ITenistaRepository iTenistaRepository;
    public TenistaService() { TenistaRepository=new TenistaRepository();}

    @Override
    public List<Tenista> FindAll() throws SQLException {
        return ITenistaRepository.FindAll();
    }

    @Override
    public boolean Save(Sponsor sponsor) {
        return ITenistaRepository.Save(sponsor);
    }

    @Override
    public Sponsor FindById(int id) throws SQLException {
        return iTenistaRepository.FindById(id);
    }

    @Override
    public boolean Delete(int id) {
        return ITenistaRepository.Delete(id);
    }

    @Override
    public boolean Update(Tenista tenista) {
        return ITenistaRepository.Update(tenista);
    }
}
}
