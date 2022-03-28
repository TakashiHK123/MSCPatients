package com.example.msc.patients.rowMapper;

import com.example.msc.patients.entity.Contactos;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ContactosRowMapper implements RowMapper<Contactos> {

    @Override
    public Contactos mapRow(final ResultSet resultSet, final int rowNum) throws SQLException {

        final Contactos contactos = new Contactos();
        contactos.setIdContacto(resultSet.getInt("id_contacto"));
        contactos.setTipo(resultSet.getString("tipo"));
        contactos.setValor(resultSet.getString("valor"));
        contactos.setIdDatosPersonales(resultSet.getInt("id_datos_personales"));

        return contactos;
    }
}
