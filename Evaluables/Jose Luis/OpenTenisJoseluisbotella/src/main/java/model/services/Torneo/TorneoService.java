package model.services.Torneo;

import model.entity.Sponsor;
import model.entity.Tenista;
import model.entity.Torneo;
import model.repository.Tenista.ITenistaRepository;
import model.repository.Tenista.TenistaRepository;
import model.repository.Torneo.ITorneoRepository;
import model.repository.Torneo.TorneoRepository;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class TorneoService implements ITorneoService{
    private ITorneoRepository iTorneoRepository;
    public TorneoService() throws IOException {
        iTorneoRepository =new TorneoRepository();}


    @Override
    public List FindAll() throws SQLException {
        return iTorneoRepository.FindAll();
    }

    @Override
    public Torneo FindById(String id) throws SQLException {
        return iTorneoRepository.FindById(id);
    }

    @Override
    public void Save(Torneo torneo) {

        iTorneoRepository.Save(torneo);
    }



    @Override
    public boolean Delete(String id) {

        return false;
    }

    @Override
    public boolean Update(Torneo torneo) {
        return false;
    }
}

