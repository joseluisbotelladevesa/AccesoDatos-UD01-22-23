package model.services.Sponsor;

import model.entity.Sponsor;
import model.repository.Sponsor.ISponsorRepository;
import model.repository.Sponsor.SponsorRepository;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

public class SponsorService implements ISponsorService{
    private ISponsorRepository iSponsorRepository;
    public SponsorService() throws IOException { iSponsorRepository=new SponsorRepository();}

    @Override
    public List<Sponsor> FindAll() throws SQLException {
        return iSponsorRepository.FindAll();
    }

    @Override
    public void Save(Sponsor sponsor) {

        iSponsorRepository.Save(sponsor);
    }

    @Override
    public Sponsor FindById(int codigo) throws SQLException {
        return iSponsorRepository.FindById(codigo);
    }

    @Override
    public boolean Delete(int id) {
        return iSponsorRepository.Delete(id);
    }

    @Override
    public boolean Update(Sponsor sponsor) {
        return iSponsorRepository.Update(sponsor);
    }
}


