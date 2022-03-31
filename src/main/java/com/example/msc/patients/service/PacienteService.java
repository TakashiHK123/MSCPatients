package com.example.msc.patients.service;

import com.example.msc.patients.converter.DatoPersonalConverter;
import com.example.msc.patients.converter.PacienteConverter;
import com.example.msc.patients.entity.DatoPersonal;
import com.example.msc.patients.entity.Paciente;
import com.example.msc.patients.model.response.PacienteResponse;
import com.example.msc.patients.model.resquest.PacienteRequest;
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
    @Autowired
    private DatoPersonalConverter datoPersonalConverter;

    //Obtener lista pacienteResponse
    public List<PacienteResponse> findAll(){
        return pacienteConverter.entitiesToModels(pacienteRepository.getAll());
    }

    public PacienteResponse save(PacienteRequest request){

        DatoPersonal datoPersonal = datoPersonalConverter.modelToEntity(request, Boolean.TRUE);
        int idDatoPersonal = datoPersonalRepository.addDatoPersonal(datoPersonal);


        Paciente entity = pacienteConverter.modelToEntity(request, idDatoPersonal, "estado");

        pacienteRepository.addPacientes(entity);

        return pacienteConverter.entityToModel(entity);
    }

}
