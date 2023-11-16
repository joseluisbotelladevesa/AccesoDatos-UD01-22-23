package controller;

import model.entity.Contrato;
import model.entity.Sponsor;
import model.entity.Tenista;
import model.services.Tenista.ITenistaService;
import model.services.Tenista.TenistaService;

import javax.swing.text.html.parser.Entity;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class TenistaControler {
    private ITenistaService iTenistaService;

    public TenistaControler() throws IOException {
        this.iTenistaService = new TenistaService();
    }

    public List<Tenista> GetAllTenistas() throws SQLException {

        return this.iTenistaService.FindAll();

    }

    public Tenista GetTenistabyid(String id) throws SQLException {
        return this.iTenistaService.FindById(id);
    }


    public void CrearTenista(Tenista tenista) {

        this.iTenistaService.Save(tenista);
    }

    public boolean UpdateTenista(Tenista tenista) {

        return this.iTenistaService.Update(tenista);
    }

    public boolean Delete(String id) {
        return this.iTenistaService.Delete(id);
    }

    public boolean AddTorneoGanado(String codTenista, String codTorneo) {
        return this.iTenistaService.AddTorneoGanado(codTenista, codTorneo);
    }

    public boolean AddContrato(String codSponsor, String codTenista, LocalDate fechaInicio, LocalDate fechaFin, double saldo) {
        return this.iTenistaService.AddContrato(codSponsor, codTenista, fechaInicio, fechaFin, saldo);
    }

    public int GetPointsByTenista(String codTenista) {
        return iTenistaService.GetPointsByTenista(codTenista);
    }


    public List<Entity> GetTenistaWithSponsor() {
        return iTenistaService.GetTenistaWithSponsor();

    }

}