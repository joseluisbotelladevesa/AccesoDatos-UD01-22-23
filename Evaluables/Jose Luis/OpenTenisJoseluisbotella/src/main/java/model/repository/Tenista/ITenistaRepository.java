package model.repository.Tenista;

import model.entity.Contrato;
import model.entity.Tenista;
import model.repository.ICrudRepository;

import java.time.LocalDate;

public interface ITenistaRepository extends ICrudRepository<Tenista, String> {

    boolean AddTorneoGanado(String codTenista, String codTorneo);

    boolean AddContrato(String codSponsor, String codTenista, LocalDate
            fechaInicio, LocalDate fechaFin, double saldo);


}
