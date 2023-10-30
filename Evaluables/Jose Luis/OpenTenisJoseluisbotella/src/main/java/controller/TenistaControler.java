package controller;

import model.entity.Sponsor;
import model.entity.Tenista;
import model.services.Sponsor.ISponsorService;
import model.services.Sponsor.SponsorService;
import model.services.Tenista.ITenistaService;
import model.services.Tenista.TenistaService;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class TenistaControler {
    private ITenistaService iTenistaService;

    public TenistaControler() throws IOException {
        this.iTenistaService= new TenistaService();
    }

    public List<Sponsor> GetAllProducts() throws SQLException {

        return this.iTenistaService.FindAll();

    }

    public Sponsor GetProductId(int id) throws SQLException {
        return this.iTenistaService.FindById(id);
    }


    public boolean CreateProduct(Tenista tenista){
        return this.iTenistaService.Save(tenista);
    }
}
}
