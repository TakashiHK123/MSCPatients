package com.example.msc.patients.model.response;

import com.example.msc.patients.entity.Contacto;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class PacienteResponse {

    @JsonProperty("id")
    private int idPacientes;
    @JsonProperty("first_name")
    private String nombre;
    @JsonProperty("last_name")
    private String apellido;
    @JsonProperty("entry_date")
    private Date fechaIngreso;
    @JsonProperty("birth_date")
    private Date fechaNacimiento;
    @JsonProperty("weight")
    private double peso;
    @JsonProperty("document_number")
    private String nro_documento;
    @JsonProperty("contacts")
    private List<Contacto> contacto;

}
