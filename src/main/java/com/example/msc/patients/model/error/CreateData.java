package com.example.msc.patients.model.error;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateData {

    @JsonProperty(value = "dataCreate")
    private ResourceCreate create;
}
