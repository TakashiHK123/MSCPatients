package com.example.msc.patients.rowMapper;



import com.example.msc.patients.entity.DatoPersonal;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DatosPersonaleRowMapper implements RowMapper<DatoPersonal> {

    @Override
    public DatoPersonal mapRow(final ResultSet resultSet, final int rowNum) throws SQLException {
        final DatoPersonal datosPersonales = new DatoPersonal();
        datosPersonales.setIdDatosPersonales(resultSet.getInt("id_datos_personales"));
        datosPersonales.setNombre(resultSet.getString("nombre"));
        datosPersonales.setApellido(resultSet.getString("apellido"));
        datosPersonales.setNroDocumento(resultSet.getString("nro_documento"));
        datosPersonales.setFechaNacimiento(resultSet.getDate("fecha_nacimiento"));
        datosPersonales.setPeso(resultSet.getDouble("peso"));
        return datosPersonales;
    }
}
