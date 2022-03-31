package com.example.msc.patients.converter;

import com.example.msc.patients.entity.Contacto;
import com.example.msc.patients.entity.DatoPersonal;
import com.example.msc.patients.model.response.PacienteResponse;
import com.example.msc.patients.model.resquest.PacienteRequest;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

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

    public PacienteResponse entityToModel(DatoPersonal datosPersonales){
        if(datosPersonales == null)
            return null;
        PacienteResponse model = new PacienteResponse();
        //ContactoRepository contactoRepository = new ContactoRepository();
        List<Contacto> contactos = new ArrayList<>();
        //contactos = contactoRepository.getContactos(entity.getIdDatosPersonales());
        model.setNombre(datosPersonales.getNombre());
        model.setApellido(datosPersonales.getApellido());
        model.setNro_documento(datosPersonales.getNroDocumento());
        model.setFechaNacimiento(datosPersonales.getFechaNacimiento());
        model.setPeso(datosPersonales.getPeso());
        return model;
    }
}
