package com.example.msc.patients.model.resquest;

import com.example.msc.patients.entity.Contacto;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PacienteRequest {

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
    private Contacto contacto;
}
