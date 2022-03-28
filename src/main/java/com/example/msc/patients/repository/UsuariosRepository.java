package com.example.msc.patients.repository;


import com.example.msc.patients.entity.Usuario;

import com.example.msc.patients.rowMapper.UsuariosRowMapper;
import com.example.msc.patients.sqlerrorcode.CustomSQLErrorCodeTranslator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;
import java.util.Map;

public class UsuariosRepository {

    private static final String SQL="SELECT * FROM usuarios ";
    private static final String SQL_POST = "INSERT INTO usuarios (username, password, id_datos_personales) VALUES (?, ?, ?)";
    private static final String SQL_GET = "SELECT * FROM usuarios WHERE id_usuario = ?";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(final DataSource dataSource){
        jdbcTemplate = new JdbcTemplate(dataSource);
        final CustomSQLErrorCodeTranslator customSQLErrorCodeTranslator = new CustomSQLErrorCodeTranslator();
        jdbcTemplate.setExceptionTranslator(customSQLErrorCodeTranslator);
    }
    //GET all
    public List<Usuario> getAll() {  //ver si se va a usar, si no se elimina
        return jdbcTemplate.query(SQL, new UsuariosRowMapper());
    }
    //POST retorna un retorna el id si se genera, y si no retorna un 0 
    public int addUsuarios(String nombre, String apellido, String estado, int idDatosPersonales){

        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_POST, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, nombre);
            preparedStatement.setString(2, apellido);
            preparedStatement.setString(3, estado);
            preparedStatement.setInt(4, idDatosPersonales);
            return preparedStatement;
        },keyHolder);
        Integer id = (Integer) keyHolder.getKeys()
                .entrySet().stream()
                .filter(m  -> m.getKey().equalsIgnoreCase("id_usuario"))
                .map(Map.Entry::getValue)
                .findFirst().orElse(null);
        int idReturn=0;
        if(id!=null){
            idReturn = id;
        }else{
            idReturn=0;
        }
        return idReturn;
    }
    // GET Obtener usuario
    public Usuario getusuario(int idusuario) {
        Usuario usuario = jdbcTemplate.queryForObject(SQL_GET, new Object[] { idusuario }, new UsuariosRowMapper());
        if(usuario!=null){
            return usuario;
        }else{
            return null;
        }
    }


}
