package com.example.msc.patients.converter;


import com.example.msc.patients.entity.Paciente;
import com.example.msc.patients.model.response.PacienteResponse;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PacienteConverter {

    public List<PacienteResponse> entitiesToModels(List<Paciente> entities){
        if(entities == null || entities.isEmpty()){
            return new ArrayList<>();
        }
        List<PacienteResponse> models = new ArrayList<>();
        entities.forEach((entity) -> {
            models.add(entityToModel(entity));
        });
        return models;
    }

    public PacienteResponse entityToModel(Paciente entity){
        if(entity == null)
            return null;
        PacienteResponse model = new PacienteResponse();
        model.setIdPacientes(entity.getIdPaciente());
        model.setNombre(entity.getNombre());
        model.setApellido(entity.getApellido());
        model.setFechaIngreso(entity.getFechaIngreso());
        model.setFechaNacimiento(entity.getFechaNacimiento());
        model.setPeso(entity.getPeso());
        model.setNro_documento(entity.getNroDocumento());

        return model;
    }


}
