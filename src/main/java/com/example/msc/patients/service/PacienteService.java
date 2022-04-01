package com.example.msc.patients.service;

import com.example.msc.patients.converter.ContactoConverter;
import com.example.msc.patients.converter.PacienteConverter;
import com.example.msc.patients.entity.Contacto;
import com.example.msc.patients.entity.DatoPersonal;
import com.example.msc.patients.entity.Paciente;
import com.example.msc.patients.model.response.ContactoResponse;
import com.example.msc.patients.model.response.PacienteResponse;
import com.example.msc.patients.model.resquest.ContactoRequest;
import com.example.msc.patients.model.resquest.PacienteRequestData;
import com.example.msc.patients.repository.ContactoRepository;
import com.example.msc.patients.repository.DatoPersonalRepository;
import com.example.msc.patients.repository.PacienteRepository;
import com.example.msc.patients.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;
    @Autowired
    private ContactoRepository contactoRepository;
    @Autowired
    private DatoPersonalRepository datoPersonalRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private PacienteConverter pacienteConverter;
    @Autowired
    private ContactoConverter contactoConverter;



    //Obtener lista pacienteResponse
    public List<PacienteResponse> findAll(){
        return pacienteConverter.entitiesToModels(pacienteRepository.getAll(), datoPersonalRepository.getAll(), contactoRepository.getAll());
    }
    //Convertimos de Paciente Request a Response
    public PacienteResponse save(PacienteRequestData pacienteRequest){
        List<ContactoResponse> contactoResponses = new ArrayList<>();
        DatoPersonal datoPersonal = new DatoPersonal();
        Contacto contacto = new Contacto();
        List<ContactoRequest> contactosRequest = new ArrayList<>();
        Paciente paciente = new Paciente();
        ContactoRequest contactoRequest = new ContactoRequest();

        //Convertimos request a entity
        datoPersonal = pacienteConverter.pacienteRequestToDatoPersonal(pacienteRequest);
        //Agregamos en la base de datos en la tabla DatoPersonal
        int idDatoPersonal = datoPersonalRepository.addDatoPersonal(datoPersonal); //Agrega DatoPersonal y retorna el id para luego utilizar.

        //Convertimos request a entity
        paciente = pacienteConverter.pacienteResquestToPaciente(pacienteRequest, idDatoPersonal, "Estado");
        //Agregamos en la base de datos en la tabla Paciente
        pacienteRepository.addPacientes(paciente);

        //Convertimos Request a entity y agregamos en la base de datos Contacto
        contactosRequest=pacienteConverter.pacienteRequestToContactoRequest(pacienteRequest);

        while(contactosRequest.isEmpty()!=true){
            contactoRequest=contactosRequest.get(0);
            contacto = contactoConverter.contactoRequestToContacto(contactoRequest, idDatoPersonal);
            contactoRepository.addContacto(contacto);//agregamos el contacto en la base de datos
            contactoResponses.add(contactoConverter.contactoToContactoResponse(contacto));
            contactosRequest.remove(0);
        }
        return pacienteConverter.entityToModel(paciente, datoPersonal, contactoResponses);
    }

}
