package com.example.msc.patients.rowMapper;

import com.example.msc.patients.entity.Contacto;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ContactoRowMapper implements RowMapper<Contacto> {

    @Override
    public Contacto mapRow(final ResultSet resultSet, final int rowNum) throws SQLException {

        final Contacto contacto = new Contacto();
        contacto.setIdContacto(resultSet.getInt("id_contacto"));
        contacto.setTipo(resultSet.getString("tipo"));
        contacto.setValor(resultSet.getString("valor"));
        contacto.setIdDatosPersonales(resultSet.getInt("id_datos_personales"));

        return contacto;
    }
}
