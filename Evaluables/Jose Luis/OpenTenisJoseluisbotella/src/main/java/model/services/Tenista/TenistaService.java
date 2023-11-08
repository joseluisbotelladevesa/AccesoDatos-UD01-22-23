package model.services.Tenista;

import model.entity.Sponsor;
import model.entity.Tenista;
import model.repository.Sponsor.ISponsorRepository;
import model.repository.Sponsor.SponsorRepository;
import model.repository.Tenista.ITenistaRepository;
import model.repository.Tenista.TenistaRepository;

import java.sql.SQLException;
import java.util.List;

public class TenistaService implements ITenistaService{
    private ITenistaRepository iTenistaRepository;
    public TenistaService() {
        iTenistaRepository=new TenistaRepository();}

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
        return false;
    }

    @Override
    public boolean Update(Tenista tenista) {

        //return ITenistaRepository.Update(tenista);
        return false;
    }
}

