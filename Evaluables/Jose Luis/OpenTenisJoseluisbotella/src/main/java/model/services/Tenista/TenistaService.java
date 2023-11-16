package model.services.Tenista;

import model.entity.Contrato;
import model.entity.Sponsor;
import model.entity.Tenista;
import model.repository.Contrato.ContratoRepository;
import model.repository.Contrato.IContratoRepository;
import model.repository.Sponsor.ISponsorRepository;
import model.repository.Sponsor.SponsorRepository;
import model.repository.Tenista.ITenistaRepository;
import model.repository.Tenista.TenistaRepository;

import javax.swing.text.html.parser.Entity;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public class TenistaService implements ITenistaService{
    private ITenistaRepository iTenistaRepository;
    private IContratoRepository iContratoRepository;
    public TenistaService() throws IOException {
        iTenistaRepository=new TenistaRepository();
        iContratoRepository=new ContratoRepository();
    }


    @Override
    public List<Tenista> FindAll() throws SQLException {
        return iTenistaRepository.FindAll();
    }

    @Override
    public void Save(Tenista tenista) {

        iTenistaRepository.Save(tenista);
    }

    @Override
    public Tenista FindById(String id) throws SQLException {
        return iTenistaRepository.FindById(id);
    }

    @Override
    public boolean Delete(String id) {
       // return ITenistaRepository.Delete(id);
        return iTenistaRepository.Delete(id);
    }

    @Override
    public boolean Update(Tenista tenista) {

        //return ITenistaRepository.Update(tenista);
       return iTenistaRepository.Update(tenista);
    }

    @Override
    public boolean AddTorneoGanado(String codTenista, String codTorneo) {
        return iTenistaRepository.AddTorneoGanado(codTenista, codTorneo);
    }

    @Override
    public boolean AddContrato(String codSponsor, String codTenista, LocalDate fechaInicio, LocalDate fechaFin, double saldo) {
      boolean adsf=false;
       adsf = iContratoRepository.addContrato(codSponsor, codTenista, fechaInicio, fechaFin, saldo);
       return adsf;
    }

    @Override
    public int GetPointsByTenista(String codTenista) {
        return iTenistaRepository.GetPointsByTenista(codTenista);
    }

    @Override
    public List<Entity> GetTenistaWithSponsor() {
        return iTenistaRepository.GetTenistaWithSponsor();

    }
}

