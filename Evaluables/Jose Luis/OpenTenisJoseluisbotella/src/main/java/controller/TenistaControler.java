package controller;

import model.entity.Sponsor;
import model.entity.Tenista;
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

    public List<Tenista> GetAllTenistas() throws SQLException {

        return this.iTenistaService.FindAll();

    }

    public Tenista GetTenistabyid(String id) throws SQLException {
        return this.iTenistaService.FindById(id);
    }


    public void CrearTenista(Tenista tenista){

        this.iTenistaService.Save(tenista);
    }

    public boolean UpdateTenista(Tenista tenista){

    return this.iTenistaService.Update(tenista);
    }
    public boolean Delete(String id){
        return this.iTenistaService.Delete(id);
    }
}
