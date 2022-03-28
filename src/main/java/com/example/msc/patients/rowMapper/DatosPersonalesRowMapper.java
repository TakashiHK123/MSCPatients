package com.example.msc.patients.rowMapper;



import com.example.msc.patients.entity.DatosPersonale;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DatosPersonalesRowMapper implements RowMapper<DatosPersonale> {

    @Override
    public DatosPersonale mapRow(final ResultSet resultSet, final int rowNum) throws SQLException {
        final DatosPersonale datosPersonales = new DatosPersonale();
        datosPersonales.setIdDatosPersonales(resultSet.getInt("id_datos_personales"));
        datosPersonales.setNombre(resultSet.getString("nombre"));
        datosPersonales.setApellido(resultSet.getString("apellido"));
        datosPersonales.setNroDocumento(resultSet.getString("nro_documento"));
        datosPersonales.setFechaNacimiento(resultSet.getDate("fecha_nacimiento"));
        datosPersonales.setPeso(resultSet.getDouble("peso"));
        return datosPersonales;
    }
}
