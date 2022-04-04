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
public class ResourceError {

    @JsonProperty(value = "code")
    private Integer errCode;
    @JsonProperty(value = "description")
    private String errDescription;
    @JsonProperty(value = "ref_description")
    private String refDescription;
    @JsonProperty(value = "ref_resource_code")
    private String refResourceCode;

    public static ResourceError internalServerError(String description){
        ResourceError error = new ResourceError();
        error.setErrCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        error.setErrDescription(HttpStatus.INTERNAL_SERVER_ERROR.name());
        error.setRefDescription(description);
        return error;
    }

    public static ResourceError parameterInvalid(String description){
        ResourceError error = new ResourceError();
        error.setErrCode(HttpStatus.UNPROCESSABLE_ENTITY.value());
        error.setErrDescription(HttpStatus.UNPROCESSABLE_ENTITY.name());
        error.setRefDescription(description);
        return error;
    }

    public static ResourceError created(String description){
        ResourceError error = new ResourceError();
        error.setErrCode(HttpStatus.CREATED.value());
        error.setErrDescription(HttpStatus.CREATED.name());
        error.setRefDescription(description);
        return error;
    }

}
