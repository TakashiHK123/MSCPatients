package com.example.msc.patients.service;

import com.example.msc.patients.dto.ObtenerPascientesDTO;
import com.example.msc.patients.dto.RegistroPacientesDTO;
import com.example.msc.patients.repository.ContactosRepository;
import com.example.msc.patients.repository.DatosPersonalesRepository;
import com.example.msc.patients.repository.PacientesRepository;
import com.example.msc.patients.repository.UsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteService {

    @Autowired
    private PacientesRepository pacientesRepository;
    @Autowired
    private ContactosRepository contactosRepository;
    @Autowired
    private DatosPersonalesRepository datosPersonalesRepository;
    @Autowired
    private UsuariosRepository usuariosRepository;
    //Obtener pacientes
    public List<ObtenerPascientesDTO> findAll(){
        return null; //falta implementar
    }
}
