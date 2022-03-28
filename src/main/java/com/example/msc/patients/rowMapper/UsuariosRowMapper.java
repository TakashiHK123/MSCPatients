package com.example.msc.patients.rowMapper;



import com.example.msc.patients.entity.Usuario;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuariosRowMapper implements RowMapper<Usuario> {

    @Override
    public Usuario mapRow(final ResultSet resultSet, final int rowNum) throws SQLException {

        final Usuario usuarios= new Usuario();
        usuarios.setIdUsuario(resultSet.getInt("id_usuarios"));
        usuarios.setUsername(resultSet.getString("username"));
        usuarios.setPassword(resultSet.getString("password"));
        usuarios.setEstado(resultSet.getString("estado"));
        usuarios.setIdDatosPersonales(resultSet.getInt("id_datos_personales"));
        return usuarios;
    }
}
