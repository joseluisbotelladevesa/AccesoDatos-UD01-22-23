package model.repository.Tenista;

import model.entity.Contrato;
import model.entity.Tenista;
import model.repository.ICrudRepository;

import javax.swing.text.html.parser.Entity;
import java.time.LocalDate;
import java.util.List;

public interface ITenistaRepository extends ICrudRepository<Tenista, String> {

    boolean AddTorneoGanado(String codTenista, String codTorneo);

    //boolean AddContrato(String codTenista, String codContrato);
    int GetPointsByTenista(String codTenista);
    List<Entity> GetTenistaWithSponsor();


}
