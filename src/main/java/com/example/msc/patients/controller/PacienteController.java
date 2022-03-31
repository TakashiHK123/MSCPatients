package com.example.msc.patients.controller;

import com.example.msc.patients.model.error.ErrorData;
import com.example.msc.patients.model.error.ResourceError;
import com.example.msc.patients.model.response.PacienteResponse;
import com.example.msc.patients.model.resquest.PacienteRequest;
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

    /*@GetMapping("/agregar")
    public String addPaciente(Model model){
        return
    }*/

    /*@GetMapping("/agregar")
    public ResponseEntity<?> findAll(
            HttpServletRequest request,
            @RequestHeader("first_name") String nombre,
            @RequestHeader("last_name") String apellido,
            @RequestHeader("entry_date") Date fechaEntrada,
            @RequestHeader("birth_date") Date fechaNacimiento,
            @RequestHeader("weight") double peso,
            @RequestHeader("document_number") String nroDocumento
            )
    {
        try {
            PacienteRequest pacienteRequest = new PacienteRequest();
            return new ResponseEntity(pacienteRequest, HttpStatus.OK);
        }
        catch(Exception e){
            LOGGER.error(e.getMessage(), e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ErrorData(ResourceError.internalServerError(e.getMessage())));
        }
    }*/

    /*@PostMapping("/agregar")
    public ResponseEntity<?> addPacienteProc(@Valid @RequestBody PacienteRequest body, HttpServletRequest request){
        try {
            //LOGGER.info("Calling pacienteService.save(?)", body);
            PacienteResponse created = pacienteService.save(body);
            return new ResponseEntity(created, HttpStatus.CREATED);
        }
        catch(Exception e){
            LOGGER.error(e.getMessage(), e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ErrorData(ResourceError.internalServerError(e.getMessage())));
        }
    }*/

    @GetMapping("/listar")
    public ResponseEntity<?> getAllPaciente(){
        List<PacienteResponse> pacienteResponse = pacienteService.findAll();
        return new ResponseEntity(pacienteResponse, HttpStatus.OK);
    }

}
