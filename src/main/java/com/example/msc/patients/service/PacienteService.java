package com.example.msc.patients.service;

import com.example.msc.patients.converter.PacienteConverter;
import com.example.msc.patients.entity.DatoPersonal;
import com.example.msc.patients.entity.Paciente;
import com.example.msc.patients.model.response.PacienteResponse;
import com.example.msc.patients.model.resquest.PacienteRequest;
import com.example.msc.patients.model.resquest.PacienteRequestData;
import com.example.msc.patients.repository.ContactoRepository;
import com.example.msc.patients.repository.DatoPersonalRepository;
import com.example.msc.patients.repository.PacienteRepository;
import com.example.msc.patients.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    //Obtener lista pacienteResponse
    public List<PacienteResponse> findAll(){
        return pacienteConverter.entitiesToModels(pacienteRepository.getAll(), datoPersonalRepository.getAll());
    }
    //Convertimos de Paciente Request a Response
    public PacienteResponse save(PacienteRequestData pacienteRequest){
        DatoPersonal datoPersonal = new DatoPersonal();
        datoPersonal = pacienteConverter.pacienteRequestToDatoPersonal(pacienteRequest);
        int idDatoPersonal = datoPersonalRepository.addDatoPersonal(datoPersonal); //Agrega DatoPersonal y retorna el id para luego utilizar.
        Paciente paciente = new Paciente();
        paciente = pacienteConverter.pacienteResquestToPaciente(pacienteRequest, idDatoPersonal, "Estado");
        pacienteRepository.addPacientes(paciente); // Agrega Paciente pero no usamos el id y lo dejamos asi.
        return pacienteConverter.entityToModel(paciente, datoPersonal);
    }

}
