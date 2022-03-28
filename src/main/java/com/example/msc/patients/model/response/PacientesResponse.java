package com.example.msc.patients.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PacientesResponse {

    @JsonProperty("id_paciente")
    private int idPacientes;
    @JsonProperty("id_datos_personales")
    private int idDatosPersonales;
    @JsonProperty("fecha_ingreso")
    private Date fechaIngreso;
    @JsonProperty("estado")
    private String estado;

}
