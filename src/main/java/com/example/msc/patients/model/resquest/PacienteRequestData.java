package com.example.msc.patients.model.resquest;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PacienteRequestData {

    @JsonProperty("data")
    private PacienteRequest data;
}
