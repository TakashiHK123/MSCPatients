package com.example.msc.patients.entity;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import javax.persistence.Entity;
import java.io.Serializable;
import java.sql.Date;
@Entity
public class Paciente implements Serializable {

    private static final long serialVersionUID = 1L;
    @NotNull
    private int idPaciente;
    @NotNull
    private int idDatosPersonales;
    @NotNull
    private Date fechaIngreso;
    @NotEmpty
    private String estado;

    public Paciente() {
    }

    public Paciente(int idPaciente, int idDatosPersonales, Date fechaIngreso, String estado) {
        this.idPaciente = idPaciente;
        this.idDatosPersonales = idDatosPersonales;
        this.fechaIngreso = fechaIngreso;
        this.estado = estado;
    }

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    public int getIdDatosPersonales() {
        return idDatosPersonales;
    }

    public void setIdDatosPersonales(int idDatosPersonales) {
        this.idDatosPersonales = idDatosPersonales;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Paciente{" +
                "idPaciente=" + idPaciente +
                ", idDatosPersonales=" + idDatosPersonales +
                ", fechaIngreso=" + fechaIngreso +
                ", estado='" + estado + '\'' +
                '}';
    }
}
