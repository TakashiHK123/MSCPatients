package com.example.msc.patients.entity;


import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import org.jetbrains.annotations.NotNull;


import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
public class DatosPersonale implements Serializable {

    private static final long serialVersionUID = 1L;
    @NotNull
    private int idDatosPersonales;
    @NotEmpty
    @Min(1)
    @Max(100)
    private String nombre;
    @NotEmpty
    @Min(1)
    @Max(100)
    private String apellido;
    @NotEmpty
    @Min(1)
    @Max(15)
    private String nroDocumento;
    @NotEmpty
    private Date fechaNacimiento;
    @NotNull
    private double peso;

    public DatosPersonale() {
    }

    public DatosPersonale(@NotNull int idDatosPersonales, String nombre, String apellido, String nroDocumento, Date fechaNacimiento, @NotNull double peso) {
        this.idDatosPersonales = idDatosPersonales;
        this.nombre = nombre;
        this.apellido = apellido;
        this.nroDocumento = nroDocumento;
        this.fechaNacimiento = fechaNacimiento;
        this.peso = peso;
    }

    public int getIdDatosPersonales() {
        return idDatosPersonales;
    }

    public void setIdDatosPersonales(int idDatosPersonales) {
        this.idDatosPersonales = idDatosPersonales;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNroDocumento() {
        return nroDocumento;
    }

    public void setNroDocumento(String nroDocumento) {
        this.nroDocumento = nroDocumento;
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

    @Override
    public String toString() {
        return "DatosPersonale{" +
                "idDatosPersonales=" + idDatosPersonales +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", nroDocumento='" + nroDocumento + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                ", peso=" + peso +
                '}';
    }

}
