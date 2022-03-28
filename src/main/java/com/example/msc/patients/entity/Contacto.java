package com.example.msc.patients.entity;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import javax.persistence.Entity;
import java.io.Serializable;
@Entity
public class Contactos implements Serializable {

    private static final long serialVersionUID = 1L;
    @NotNull
    @Min(0)
    @Max(999999)
    private int idContacto;
    @NotEmpty
    private String tipo;
    @NotEmpty
    private String valor;
    @NotNull
    private int idDatosPersonales;

    public Contactos() {
    }

    public Contactos(int idContacto, String tipo, String valor, int idDatosPersonales) {
        this.idContacto = idContacto;
        this.tipo = tipo;
        this.valor = valor;
        this.idDatosPersonales = idDatosPersonales;
    }

    public int getIdContacto() {
        return idContacto;
    }

    public void setIdContacto(int idContacto) {
        this.idContacto = idContacto;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public int getIdDatosPersonales() {
        return idDatosPersonales;
    }

    public void setIdDatosPersonales(int idDatosPersonales) {
        this.idDatosPersonales = idDatosPersonales;
    }

    @Override
    public String toString() {
        return "Contactos{" +
                "idContacto=" + idContacto +
                ", tipo='" + tipo + '\'' +
                ", valor='" + valor + '\'' +
                ", idDatosPersonales=" + idDatosPersonales +
                '}';
    }
}
