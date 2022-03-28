package com.example.msc.patients.service;

import com.example.msc.patients.converter.PacienteConverter;
import com.example.msc.patients.dto.ObtenerPascientesDTO;
import com.example.msc.patients.model.response.PacienteResponse;
import com.example.msc.patients.repository.ContactoRepository;
import com.example.msc.patients.repository.DatosPersonalesRepository;
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
    private DatosPersonalesRepository datoPersonaleRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private PacienteConverter pacienteConverter;
    //Obtener pacientes
    public List<PacienteResponse> findAll(){
        return pacienteConverter.entitiesToModels(pacienteRepository.getAll()); //falta implementar
    }
}
