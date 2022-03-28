package com.example.msc.patients.entity;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import javax.persistence.Entity;
import java.io.Serializable;

@Entity
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @NotNull
    private int idUsuario;
    @NotEmpty
    private String username;
    @NotEmpty
    private String password;
    @NotEmpty
    private String estado;
    @NotNull
    private int idDatosPersonales;

    public Usuario() {
    }

    public Usuario(int idUsuario, String username, String password, String estado, int idDatosPersonales) {
        this.idUsuario = idUsuario;
        this.username = username;
        this.password = password;
        this.estado = estado;
        this.idDatosPersonales = idDatosPersonales;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getIdDatosPersonales() {
        return idDatosPersonales;
    }

    public void setIdDatosPersonales(int idDatosPersonales) {
        this.idDatosPersonales = idDatosPersonales;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "idUsuario=" + idUsuario +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", estado='" + estado + '\'' +
                ", idDatosPersonales=" + idDatosPersonales +
                '}';
    }
}
