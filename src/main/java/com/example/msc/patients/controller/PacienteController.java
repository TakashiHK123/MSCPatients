package com.example.msc.patients.controller;


import com.example.msc.patients.model.response.PacienteResponse;
import com.example.msc.patients.service.PacienteService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@CrossOrigin("*")
@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    private static final Logger LOGGER = LogManager.getLogger(PacienteController.class);

    @Autowired
    private PacienteService pacienteService;


    @GetMapping("/listar")
    public ResponseEntity<?> getAllPaciente(){
        List<PacienteResponse> pacienteResponse = pacienteService.findAll();
        return new ResponseEntity(pacienteResponse, HttpStatus.OK);
    }

}
