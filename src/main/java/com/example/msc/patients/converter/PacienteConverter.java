package com.example.msc.patients.converter;


import com.example.msc.patients.entity.Contacto;
import com.example.msc.patients.entity.Paciente;
import com.example.msc.patients.model.response.PacienteResponse;
import com.example.msc.patients.repository.ContactoRepository;
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
        //ContactoRepository contactoRepository = new ContactoRepository();
        List<Contacto> contactos = new ArrayList<>();
        //contactos = contactoRepository.getContactos(entity.getIdDatosPersonales());
        model.setIdPaciente(entity.getIdPaciente());
        model.setNombre(entity.getNombre());
        model.setApellido(entity.getApellido());
        model.setFechaIngreso(entity.getFechaIngreso());
        model.setFechaNacimiento(entity.getFechaNacimiento());
        model.setPeso(entity.getPeso());
        model.setNro_documento(entity.getNroDocumento());
        //model.setContacto(contactos);
        return model;
    }


}
