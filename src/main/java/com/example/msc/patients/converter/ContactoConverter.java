package com.example.msc.patients.converter;

import com.example.msc.patients.entity.Contacto;
import com.example.msc.patients.entity.DatoPersonal;
import com.example.msc.patients.model.response.ContactoResponse;
import com.example.msc.patients.model.resquest.ContactoRequest;
import com.example.msc.patients.model.resquest.PacienteRequestData;
import org.springframework.stereotype.Component;

@Component
public class ContactoConverter {

    public Contacto contactoRequestToContacto(ContactoRequest model, int idDatoPersonal){
        Contacto contacto = new Contacto();
        contacto.setValor(model.getValue());
        contacto.setTipo(model.getEmail());
        contacto.setIdDatosPersonales(idDatoPersonal);
        return contacto;
    }

    public ContactoResponse contactoToContactoResponse(Contacto contacto){
        ContactoResponse contactoResponse = new ContactoResponse();
        contactoResponse.setEmail(contacto.getTipo());
        contactoResponse.setValue(contacto.getValor());
        return contactoResponse;
    }
}
