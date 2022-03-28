package com.example.msc.patients.dto;

import com.example.msc.patients.entity.Contacto;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

public class RegistroPacientesDTO implements Serializable {

    @NotEmpty
    @Min(1)
    @Max(100)
    private String primerNombre;
    @NotEmpty
    @Min(1)
    @Max(100)
    private String ultimoNombre;
    private Date fechaIngreso;
    private Date fechaNacimiento;
    private double peso;
    @NotEmpty
    @Min(1)
    @Max(15)
    private String numeroDocumento;
    private List<Contacto> contacto;

    public RegistroPacientesDTO() {
    }

    public RegistroPacientesDTO(String primerNombre, String ultimoNombre, Date fechaIngreso, Date fechaNacimiento, double peso, String numeroDocumento, List<Contacto> contacto) {
        this.primerNombre = primerNombre;
        this.ultimoNombre = ultimoNombre;
        this.fechaIngreso = fechaIngreso;
        this.fechaNacimiento = fechaNacimiento;
        this.peso = peso;
        this.numeroDocumento = numeroDocumento;
        this.contacto = contacto;
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public String getUltimoNombre() {
        return ultimoNombre;
    }

    public void setUltimoNombre(String ultimoNombre) {
        this.ultimoNombre = ultimoNombre;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public List<Contacto> getContactos() {
        return contacto;
    }

    public void setContactos(List<Contacto> contactos) {
        this.contacto = contacto;
    }
}
