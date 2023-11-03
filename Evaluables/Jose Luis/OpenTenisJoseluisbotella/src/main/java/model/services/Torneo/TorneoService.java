package model.services.Torneo;

import model.entity.Sponsor;
import model.entity.Tenista;
import model.entity.Torneo;
import model.repository.Tenista.ITenistaRepository;
import model.repository.Tenista.TenistaRepository;
import model.repository.Torneo.ITorneoRepository;
import model.repository.Torneo.TorneoRepository;

import java.sql.SQLException;
import java.util.List;

public class TorneoService implements ITorneoRepository{
    private ITorneoService iTorneoService;
    public TorneoService() {
        iTorneoService =new TorneoRepository();}


    @Override
    public List FindAll() throws SQLException {
        return iTorneoService.FindAll();
    }

    @Override
    public Torneo FindById(int id) throws SQLException {
        return iTorneoService.FindById(id);
    }

    @Override
    public boolean Save(Torneo torneo) {
        return ITorneoRepository.Save(torneo);
    }

    @Override
    public boolean Delete(Object id) {
        return false;
    }

    @Override
    public boolean Update(Object entity) {
        return false;
    }
}

