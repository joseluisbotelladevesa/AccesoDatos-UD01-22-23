package org.example;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("historial")
public class Historial {
    private String nombreInstituto;
    private int anyoAcademico;
    private String asignatura;

    public Historial(String nombreInstituto, int anyoAcademico, String asignatura) {
        this.nombreInstituto = nombreInstituto;
        this.anyoAcademico = anyoAcademico;
        this.asignatura = asignatura;
    }

    public Historial() {
    }

    public String getNombreInstituto() {
        return nombreInstituto;
    }

    public void setNombreInstituto(String nombreInstituto) {
        this.nombreInstituto = nombreInstituto;
    }

    public int getAnyoAcademico() {
        return anyoAcademico;
    }

    public void setAnyoAcademico(int anyoAcademico) {
        this.anyoAcademico = anyoAcademico;
    }

    public String getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(String asignatura) {
        this.asignatura = asignatura;
    }

    @Override
    public String toString() {
        return "Historial{" +
                "nombreInstituto='" + nombreInstituto + '\'' +
                ", anyoAcademico=" + anyoAcademico +
                ", asignatura='" + asignatura + '\'' +
                '}';
    }
}
