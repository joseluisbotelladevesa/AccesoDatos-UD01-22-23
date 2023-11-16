package model.repository.Contrato;

import model.entity.Contrato;

import java.time.LocalDate;
import java.util.UUID;

public interface IContratoRepository {
    public boolean addContrato(String codSponsor, String codTenista, LocalDate
            fechaInicio, LocalDate fechaFin, double saldo);

}
