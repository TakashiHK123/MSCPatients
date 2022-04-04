package com.example.msc.patients.converter;

import com.example.msc.patients.entity.Contacto;
import com.example.msc.patients.entity.DatoPersonal;
import com.example.msc.patients.entity.Paciente;
import com.example.msc.patients.model.response.ContactoResponse;
import com.example.msc.patients.model.response.PacienteResponse;
import com.example.msc.patients.model.resquest.ContactoRequest;
import com.example.msc.patients.model.resquest.PacienteRequestData;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class PacienteConverter {


    public List<PacienteResponse> entitiesToModels(List<Paciente> entities, List<DatoPersonal> datoPersonals, List<Contacto> contactos){
        if(entities == null || entities.isEmpty() || datoPersonals == null || datoPersonals.isEmpty()){
            return new ArrayList<>();
        }

        List<PacienteResponse> pacienteResponses = new ArrayList<>();
        ContactoConverter contactoConverter = new ContactoConverter();

        for(Paciente paciente : entities){
            for(DatoPersonal datoPersonal : datoPersonals){
                    if(paciente.getIdDatosPersonales() == datoPersonal.getIdDatosPersonales()) {
                        List<ContactoResponse> contactoResponses = new ArrayList<>();
                        for(Contacto contacto : contactos){
                            if(contacto.getIdDatosPersonales() == paciente.getIdDatosPersonales()){
                                contactoResponses.add(contactoConverter.contactoToContactoResponse(contacto));
                            }
                        }
                        pacienteResponses.add(entityToModel(paciente, datoPersonal, contactoResponses));
                    }
            }
        }
        return pacienteResponses;
    }

    public PacienteResponse entityToModel(Paciente paciente, DatoPersonal datoPersonal, List<ContactoResponse> contactoResponse){
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
        model.setContactosResponse(contactoResponse);
        return model;
    }

    public Paciente pacienteResquestToPaciente(PacienteRequestData model, int idDatoPersonal, String estado){
        Paciente entity = new Paciente();
        entity.setIdDatosPersonales(idDatoPersonal);
        entity.setFechaIngreso(model.getData().getFechaIngreso()); //el unico atributo del request utilizado a convertir
        entity.setEstado(estado);
        return entity;
    }

    public DatoPersonal pacienteRequestToDatoPersonal(PacienteRequestData model){
        DatoPersonal datoPersonal = new DatoPersonal();
        datoPersonal.setNombre(model.getData().getNombre());
        datoPersonal.setApellido(model.getData().getApellido());
        datoPersonal.setNroDocumento(model.getData().getNro_documento());
        datoPersonal.setFechaNacimiento(model.getData().getFechaNacimiento());
        datoPersonal.setPeso(model.getData().getPeso());
        return datoPersonal;
    }

    public List<ContactoRequest> pacienteRequestToContactoRequest(PacienteRequestData model){
        List<ContactoRequest> contactos = new ArrayList<>();
        contactos=model.getData().getContactosRequest();
        return contactos;
    }

}
