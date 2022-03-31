package com.example.msc.patients.converter;

import com.example.msc.patients.entity.DatoPersonal;
import com.example.msc.patients.model.resquest.PacienteRequest;
import org.springframework.stereotype.Component;

@Component
public class DatoPersonalConverter {

    public DatoPersonal modelToEntity(PacienteRequest model, Boolean insert){
        DatoPersonal entity = new DatoPersonal();
        entity.setNombre(model.getNombre());
        entity.setApellido(model.getApellido());
        entity.setNroDocumento(model.getNro_documento());
        entity.setFechaNacimiento(model.getFechaNacimiento());
        entity.setPeso(model.getPeso());
        return entity;
    }
}
