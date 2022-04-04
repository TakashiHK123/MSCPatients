package com.example.msc.patients.model.resquest;


import com.example.msc.patients.entity.Contacto;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.sql.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PacienteRequest {

    @JsonProperty("first_name")
    @NotNull
    @NotEmpty
    private String nombre;
    @JsonProperty("last_name")
    @NotEmpty
    @NotNull
    private String apellido;
    @JsonProperty("entry_date")
    @NotNull
    private Date fechaIngreso;
    @JsonProperty("birth_date")
    @NotNull
    private Date fechaNacimiento;
    @JsonProperty("weight")
    @NotNull
    private double peso;
    @JsonProperty("document_number")
    @NotEmpty
    @NotNull
    private String nro_documento;
    @JsonProperty("contacts")
    private List<ContactoRequest> contactosRequest;
}
