package controller;

import model.entity.Sponsor;
import model.services.Sponsor.ISponsorService;
import model.services.Sponsor.SponsorService;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class SponsorControler {
    private ISponsorService iSponsorService;

    public SponsorControler() throws IOException {
        this.iSponsorService= new SponsorService();
    }

    public List<Sponsor> GetAllSponsors() throws SQLException {

        return this.iSponsorService.FindAll();

    }

    public Sponsor GetSponsorbyid(int id) throws SQLException {
        return this.iSponsorService.FindById(id);
    }


    public void CrearSponsor (Sponsor sponsor){

        this.iSponsorService.Save(sponsor);
    }
}
