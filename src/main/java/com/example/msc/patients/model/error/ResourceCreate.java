package com.example.msc.patients.model.error;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResourceCreate {

    @JsonProperty(value = "code")
    private Integer Code;
    @JsonProperty(value = "description")
    private String Description;

    public static ResourceCreate patientCreated(String description){
        ResourceCreate create = new ResourceCreate();
        create.setCode(HttpStatus.CREATED.value());
        create.setDescription(HttpStatus.CREATED.name());
        return create;
    }

}
