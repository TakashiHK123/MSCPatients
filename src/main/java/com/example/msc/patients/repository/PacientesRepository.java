package com.example.msc.patients.repository;


import com.example.msc.patients.entity.Paciente;
import com.example.msc.patients.rowMapper.PacientesRowMapper;
import com.example.msc.patients.sqlerrorcode.CustomSQLErrorCodeTranslator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;
import java.util.Map;

@Repository
public class PacientesRepository {

    private static final String SQL="SELECT * FROM pacientes ";
    private static final String SQL_POST = "INSERT INTO pacientes (id_datos_personales, fecha_ingreso, estado) VALUES (?, ?, ?)";
    private static final String SQL_GET = "SELECT * FROM pacientes WHERE id_pacientes = ?";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(final DataSource dataSource){
        jdbcTemplate = new JdbcTemplate(dataSource);
        final CustomSQLErrorCodeTranslator customSQLErrorCodeTranslator = new CustomSQLErrorCodeTranslator();
        jdbcTemplate.setExceptionTranslator(customSQLErrorCodeTranslator);
    }
    //GET all
    public List<Paciente> getAll() {  //ver si se va a usar, si no se elimina
        return jdbcTemplate.query(SQL, new PacientesRowMapper());
    }
    //POST retorna un retorna el id si se genera, y si no retorna un 0 
    public int addPacientes(int idpaciente, Date fechaIngreso, String estado){

        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_POST, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, idpaciente);
            preparedStatement.setDate(2, fechaIngreso);
            preparedStatement.setString(3, estado);
            return preparedStatement;
        },keyHolder);
        Integer id = (Integer) keyHolder.getKeys()
                .entrySet().stream()
                .filter(m  -> m.getKey().equalsIgnoreCase("id_paciente"))
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
    // GET Obtener Paciente
    public Paciente getPaciente(int idPaciente) {
        Paciente paciente = jdbcTemplate.queryForObject(SQL_GET, new Object[] { idPaciente }, new PacientesRowMapper());
        if(paciente!=null){
            return paciente;
        }else{
            return null;
        }
    }
}
