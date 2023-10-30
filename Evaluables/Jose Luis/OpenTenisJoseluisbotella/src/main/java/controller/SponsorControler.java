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

    public List<Sponsor> GetAllProducts() throws SQLException {

        return this.iSponsorService.FindAll();

    }

    public Sponsor GetProductId(int id) throws SQLException {
        return this.iSponsorService.FindById(id);
    }


    public boolean CreateProduct(Sponsor sponsor){
        return this.iSponsorService.Save(sponsor);
    }
}