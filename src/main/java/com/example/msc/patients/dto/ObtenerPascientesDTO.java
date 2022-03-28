package com.example.msc.patients.dto;

import com.example.msc.patients.entity.Contactos;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import org.jetbrains.annotations.NotNull;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

public class ObtenerPascientesDTO implements Serializable {

    @NotNull
    private int id;
    @NotEmpty
    @Min(1)
    @Max(100)
    private String primerNombre;
    @NotEmpty
    @Min(1)
    @Max(100)
    private String ultimoNombre;
    @NotNull
    private Date fechaIngreso;
    @NotNull
    private Date fechaNacimiento;
    @NotNull
    private double peso;
    @NotEmpty
    @Min(1)
    @Max(15)
    private String numeroDocumento;
    private List<Contactos> contactos;

    public ObtenerPascientesDTO() {
    }

    public ObtenerPascientesDTO(@NotNull int id, String primerNombre, String ultimoNombre, @NotNull Date fechaIngreso, @NotNull Date fechaNacimiento, @NotNull double peso, String numeroDocumento, List<Contactos> contactos) {
        this.id = id;
        this.primerNombre = primerNombre;
        this.ultimoNombre = ultimoNombre;
        this.fechaIngreso = fechaIngreso;
        this.fechaNacimiento = fechaNacimiento;
        this.peso = peso;
        this.numeroDocumento = numeroDocumento;
        this.contactos = contactos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public List<Contactos> getContactos() {
        return contactos;
    }

    public void setContactos(List<Contactos> contactos) {
        this.contactos = contactos;
    }
}
