package controller;

import model.entity.Tenista;
import model.entity.Torneo;
import model.services.Tenista.ITenistaService;
import model.services.Tenista.TenistaService;
import model.services.Torneo.ITorneoService;
import model.services.Torneo.TorneoService;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class TorneoControler {
    private ITorneoService iTorneoService;

    public TorneoControler() throws IOException {
        this.iTorneoService= new TorneoService();
    }

    public List<Torneo> GetAllTorneos() throws SQLException {

        return this.iTorneoService.FindAll();

    }

    public Torneo GetTorneobyid(String id) throws SQLException {
        return this.iTorneoService.FindById(id);
    }


    public void CrearTorneo(Torneo torneo){
        this.iTorneoService.Save(torneo);
    }
    public boolean UpdateTorneo(Torneo torneo){

        return this.iTorneoService.Update(torneo);
    }
    public boolean Delete(String id){
        return this.iTorneoService.Delete(id);
    }
}

