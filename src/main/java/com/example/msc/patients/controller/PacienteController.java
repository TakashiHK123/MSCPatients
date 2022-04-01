package com.example.msc.patients.controller;

import com.example.msc.patients.model.error.ErrorData;
import com.example.msc.patients.model.error.ResourceError;
import com.example.msc.patients.model.response.PacienteResponse;
import com.example.msc.patients.model.resquest.PacienteRequestData;
import com.example.msc.patients.service.PacienteService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
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

    @PostMapping
    public ResponseEntity<?> save(@Valid @RequestBody PacienteRequestData body, HttpServletRequest request){
        try {
            PacienteResponse pacienteResponse = pacienteService.save(body);
            return new ResponseEntity<>(pacienteResponse, HttpStatus.CREATED);
        }
        catch(Exception e){
            LOGGER.error(e.getMessage(), e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ErrorData(ResourceError.internalServerError(e.getMessage())));
        }
    }

    @GetMapping
    public ResponseEntity<?> getAllPaciente(){
        List<PacienteResponse> pacienteResponse = pacienteService.findAll();
        return new ResponseEntity(pacienteResponse, HttpStatus.OK);
    }


}
