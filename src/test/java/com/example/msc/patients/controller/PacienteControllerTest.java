package com.example.msc.patients.controller;

import com.example.msc.patients.entity.Contacto;
import com.example.msc.patients.entity.DatoPersonal;
import com.example.msc.patients.entity.Paciente;
import com.example.msc.patients.entity.Usuario;
import com.example.msc.patients.model.error.CreateData;
import com.example.msc.patients.model.error.ResourceCreate;
import com.example.msc.patients.model.response.ContactoResponse;
import com.example.msc.patients.model.response.PacienteResponse;
import com.example.msc.patients.model.resquest.PacienteRequestData;
import com.example.msc.patients.repository.ContactoRepository;
import com.example.msc.patients.repository.DatoPersonalRepository;
import com.example.msc.patients.repository.PacienteRepository;
import com.example.msc.patients.repository.UsuarioRepository;
import com.example.msc.patients.service.PacienteService;
import io.swagger.models.Response;
import jakarta.servlet.http.HttpServletRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PacienteControllerTest {


    @Autowired
    HttpServletRequest request;

    PacienteController pacienteController = Mockito.mock(PacienteController.class);

    PacienteService pacienteService = Mockito.mock(PacienteService.class);

    PacienteResponse pacienteResponse = Mockito.mock(PacienteResponse.class);

    PacienteRequestData pacienteRequestData = Mockito.mock(PacienteRequestData.class);


    @BeforeEach
    void setUp() {
        pacienteResponse.setNombre("Nombre");
        pacienteResponse.setApellido("Apellido");
        pacienteResponse.setFechaIngreso(Date.valueOf("2001-10-10"));
        pacienteResponse.setFechaNacimiento(Date.valueOf("1994-05-13"));
        pacienteResponse.setNro_documento("asdf12");
        List<ContactoResponse> contactosResponses = new ArrayList<>();
        pacienteResponse.setContactosResponse(contactosResponses);
        List<PacienteResponse> pacienteResponses = new ArrayList<>();
        pacienteResponses.add(pacienteResponse);
        Mockito.when(pacienteService.findAll()).thenReturn(pacienteResponses);
    }



    @Test
    void getAllPaciente() {
        ResponseEntity<?> respuestaPacienteResponse;
        respuestaPacienteResponse = pacienteController.getAllPaciente();

    }


    @Test
    void save() {
        ResponseEntity<?> pacienteRequestDataPost;
        pacienteRequestDataPost = pacienteController.save(pacienteRequestData,request);
    }
}