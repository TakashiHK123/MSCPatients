package com.example.msc.patients.controller;

import com.example.msc.patients.model.error.ErrorData;
import com.example.msc.patients.model.error.ResourceError;
import com.example.msc.patients.model.response.PacienteResponse;

import com.example.msc.patients.service.PacienteService;
import jakarta.servlet.http.HttpServletRequest;

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

    @ResponseBody
    @RequestMapping("/listar")
    public ResponseEntity<?> findAll(HttpServletRequest request){
        try {
            List<PacienteResponse> pacientes = pacienteService.findAll();
            if(pacientes == null || pacientes.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(pacientes, HttpStatus.OK);
        }
        catch(Exception e){
            LOGGER.error(e.getMessage(), e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ErrorData(ResourceError.internalServerError(e.getMessage())));
        }
    }

}
