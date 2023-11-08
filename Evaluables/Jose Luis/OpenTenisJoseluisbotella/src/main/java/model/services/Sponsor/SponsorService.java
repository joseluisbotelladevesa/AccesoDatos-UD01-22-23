package model.services.Sponsor;

import model.entity.Sponsor;
import model.repository.Sponsor.ISponsorRepository;
import model.repository.Sponsor.SponsorRepository;

import java.sql.SQLException;
import java.util.List;

public class SponsorService implements ISponsorService{
    private ISponsorRepository iSponsorRepository;
    public SponsorService() { iSponsorRepository=new SponsorRepository();}

    @Override
    public List<Sponsor> FindAll() throws SQLException {
        return iSponsorRepository.FindAll();
    }

    @Override
    public void Save(Sponsor sponsor) {

        iSponsorRepository.Save(sponsor);
    }

    @Override
    public Sponsor FindById(Integer codigo) throws SQLException {
        return (Sponsor) iSponsorRepository.FindById(codigo);
    }

    @Override
    public boolean Delete(Integer id) {
        return iSponsorRepository.Delete(id);
    }

    @Override
    public boolean Update(Sponsor sponsor) {
        return iSponsorRepository.Update(sponsor);
    }
}


