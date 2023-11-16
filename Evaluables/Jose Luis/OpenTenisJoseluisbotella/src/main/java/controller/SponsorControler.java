package controller;

import model.entity.Sponsor;
import model.entity.Tenista;
import model.services.Sponsor.ISponsorService;
import model.services.Sponsor.SponsorService;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

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


    public void Save (Sponsor sponsor){

        this.iSponsorService.Save(sponsor);
    }
    public boolean UpdateSponsor(Sponsor sponsor){

        return this.iSponsorService.Update(sponsor);
    }
    public boolean Delete(int id){
        return this.iSponsorService.Delete(id);
    }

    public List<Sponsor>GetSponsorMoreRich(){
        return this.iSponsorService.GetSponsorMoreRich();
    }
}
