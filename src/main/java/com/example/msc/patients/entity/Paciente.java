package com.example.msc.patients.entity;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import javax.persistence.Entity;
import java.io.Serializable;
import java.sql.Date;
@Entity
public class Paciente extends DatoPersonal implements Serializable {

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

    public Paciente(@org.jetbrains.annotations.NotNull int idDatosPersonales, String nombre, String apellido, String nroDocumento, Date fechaNacimiento, @org.jetbrains.annotations.NotNull double peso, int idPaciente, int idDatosPersonales1, Date fechaIngreso, String estado) {
        super(idDatosPersonales, nombre, apellido, nroDocumento, fechaNacimiento, peso);
        this.idPaciente = idPaciente;
        this.idDatosPersonales = idDatosPersonales1;
        this.fechaIngreso = fechaIngreso;
        this.estado = estado;
    }

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    @Override
    public int getIdDatosPersonales() {
        return idDatosPersonales;
    }

    @Override
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
