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
        return ISponsorRepository.FindAll();
    }

    @Override
    public boolean Save(Sponsor sponsor) {
        return ISponsorRepository.Save(sponsor);
    }

    @Override
    public Sponsor FindById(int id) throws SQLException {
        return iSponsorRepository.FindById(id);
    }

    @Override
    public boolean Delete(int id) {
        return ISponsorRepository.Delete(id);
    }

    @Override
    public boolean Update(Sponsor sponsor) {
        return iSponsorRepository.Update(category);
    }
}


}
