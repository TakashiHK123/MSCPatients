package com.example.msc.patients.converter;

import com.example.msc.patients.entity.DatoPersonal;
import com.example.msc.patients.entity.Paciente;
import com.example.msc.patients.model.response.PacienteResponse;
import com.example.msc.patients.model.resquest.PacienteRequest;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class PacienteConverter {


    public List<PacienteResponse> entitiesToModels(List<Paciente> entities, List<DatoPersonal> datoPersonals){
        if(entities == null || entities.isEmpty() || datoPersonals == null || datoPersonals.isEmpty()){
            return new ArrayList<>();
        }
        List<PacienteResponse> models = new ArrayList<>();
        for(Paciente paciente : entities){
            for(DatoPersonal datoPersonal : datoPersonals){
                if(paciente.getIdDatosPersonales()==datoPersonal.getIdDatosPersonales()){
                    models.add(entityToModel(paciente, datoPersonal));
                }
            }
        }
        /*entities.forEach((entity)->{
            datoPersonals.forEach((entity2) -> {
                models.add(entityToModel2(entity));
                models.add(models.size()-1,entityToModel3(entity2));

            });

        });*/
        return models;
    }

    public PacienteResponse entityToModel(Paciente paciente, DatoPersonal datoPersonal){
        if(paciente == null || datoPersonal == null)
            return null;
        PacienteResponse model = new PacienteResponse();
        model.setIdPaciente(paciente.getIdPaciente());
        model.setFechaIngreso(paciente.getFechaIngreso());
        model.setNombre(datoPersonal.getNombre());
        model.setApellido(datoPersonal.getApellido());
        model.setNro_documento(datoPersonal.getNroDocumento());
        model.setPeso(datoPersonal.getPeso());
        model.setFechaNacimiento(datoPersonal.getFechaNacimiento());
        return model;
    }

    public PacienteResponse entityToModel2(Paciente paciente){
        if(paciente == null)
            return null;
        PacienteResponse model = new PacienteResponse();
        model.setIdPaciente(paciente.getIdPaciente());
        model.setFechaIngreso(paciente.getFechaIngreso());
        return model;
    }

    public PacienteResponse entityToModel3(DatoPersonal datoPersonal){
        if(datoPersonal == null)
            return null;
        PacienteResponse model = new PacienteResponse();
        model.setNombre(datoPersonal.getNombre());
        model.setApellido(datoPersonal.getApellido());
        model.setNro_documento(datoPersonal.getNroDocumento());
        model.setPeso(datoPersonal.getPeso());
        model.setFechaNacimiento(datoPersonal.getFechaNacimiento());
        return model;
    }



    public Paciente modelToEntity(PacienteRequest model, int idDatoPersonal, String estado){
        Paciente entity = new Paciente();
        entity.setIdDatosPersonales(idDatoPersonal);
        entity.setFechaIngreso(model.getFechaIngreso());
        entity.setEstado(estado);
        return entity;
    }


}
