package com.example.msc.patients.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContactoResponse {

    @JsonProperty("type")
    private String email;
    @JsonProperty("value")
    private String value;

}
