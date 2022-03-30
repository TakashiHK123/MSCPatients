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

    public static ResourceError notFound(String description){
        ResourceError error = new ResourceError();
        error.setErrCode(HttpStatus.NOT_FOUND.value());
        error.setErrDescription(HttpStatus.NOT_FOUND.name());
        error.setRefDescription(description);
        return error;
    }

}
