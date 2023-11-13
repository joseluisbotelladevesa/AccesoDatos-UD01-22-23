package model.entity;

import java.util.UUID;

public class TorneoGanado {
    UUID codTenista;
    UUID codTorneo;

    public TorneoGanado(UUID codTenista, UUID codTorneo) {
        this.codTenista = codTenista;
        this.codTorneo = codTorneo;
    }

    public TorneoGanado() {
    }

    public UUID getCodTenista() {
        return codTenista;
    }

    public void setCodTenista(UUID codTenista) {
        this.codTenista = codTenista;
    }

    public UUID getCodTorneo() {
        return codTorneo;
    }

    public void setCodTorneo(UUID codTorneo) {
        this.codTorneo = codTorneo;
    }
}
