package com.example.msc.patients.controller;

import com.example.msc.patients.model.response.ContactoResponse;
import com.example.msc.patients.model.response.PacienteResponse;
import com.example.msc.patients.model.resquest.PacienteRequestData;
import com.example.msc.patients.repository.ContactoRepository;
import com.example.msc.patients.repository.DatoPersonalRepository;
import com.example.msc.patients.repository.PacienteRepository;
import com.example.msc.patients.repository.UsuarioRepository;
import com.example.msc.patients.service.PacienteService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PacienteControllerTest {

    @Autowired
    private PacienteService pacienteService;
    ContactoRepository contactoRepositoryMock = Mockito.mock(ContactoRepository.class);
    PacienteRepository pacienteRepositoryMock = Mockito.mock(PacienteRepository.class);
    DatoPersonalRepository datoPersonalRepositoryMock = Mockito.mock(DatoPersonalRepository.class);
    UsuarioRepository usuarioRepository = Mockito.mock(UsuarioRepository.class);
    @Autowired
    private PacienteController pacienteController;

    @BeforeEach
    void setUp(){
        ContactoResponse contactoResponse = new ContactoResponse();
        contactoResponse.setValue("value");
        contactoResponse.setEmail("email");
        List<ContactoResponse> contactos = new ArrayList<>();
        contactos.add(contactoResponse);
        PacienteResponse pacienteResponseMock = new PacienteResponse();
        pacienteResponseMock.setIdPaciente(1);
        pacienteResponseMock.setNombre("TESTNombre");
        pacienteResponseMock.setApellido("TESTApellido");
        pacienteResponseMock.setFechaIngreso(new Date(2001,10,10));
        pacienteResponseMock.setFechaNacimiento(new Date(1994,05,13));
        pacienteResponseMock.setPeso(80.2);
        pacienteResponseMock.setNro_documento("F12");
        pacienteResponseMock.setContactosResponse(contactos);

    }


    @Test
    void getAllPaciente() {
        Mockito.when(pacienteController.getAllPaciente());
    }
}