package model.services.Tenista;

import model.entity.Contrato;
import model.entity.Tenista;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public interface ITenistaService {
    public List<Tenista> FindAll() throws SQLException;
    public void Save(Tenista tenista);
    public Tenista FindById(String id) throws SQLException;
    public boolean Delete(String id);
    public boolean Update(Tenista tenista);
    boolean AddTorneoGanado(String codTenista, String codTorneo);

    boolean AddContrato(String codSponsor, String codTenista, LocalDate
            fechaInicio, LocalDate fechaFin, double saldo);
}

