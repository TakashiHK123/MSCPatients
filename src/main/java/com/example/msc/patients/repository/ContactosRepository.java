package com.example.msc.patients.repository;

import com.example.msc.patients.entity.Contacto;
import com.example.msc.patients.rowMapper.ContactosRowMapper;
import com.example.msc.patients.sqlerrorcode.CustomSQLErrorCodeTranslator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Map;
//Cree el contactoRepository2, porque no me deja modifiar el otro usar este repository

@Repository
public class ContactosRepository2 {

    private static final String SQL_INSERT = "INSERT INTO contactos (type, value, id_datos_personales) VALUES (?, ?, ?)";
    private static final String SQL_GET = "SELECT * FROM contactos WHERE id_contacto = ?";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(final DataSource dataSource){
        jdbcTemplate = new JdbcTemplate(dataSource);
        final CustomSQLErrorCodeTranslator customSQLErrorCodeTranslator = new CustomSQLErrorCodeTranslator();
        jdbcTemplate.setExceptionTranslator(customSQLErrorCodeTranslator);
    }
    //Agregar retorna un int de validacion
    public int addContacto(String type, String value, int idDatosPersonales) {
        return jdbcTemplate.update(SQL_INSERT, type, value, idDatosPersonales);
    }
    //GET Contactos del paciente
    public Contactos getContactos(int idContacto) {
        Contactos contactos = jdbcTemplate.queryForObject(SQL_GET, new Object[] { idContacto }, new ContactosRowMapper());
        if(contactos!=null){
            return contactos;
        }else{
            return null;
        }
    }
    //Agregar retorna Contacto
    public Contacto addContactoReturnAlu(String type, String value, int idDatosPersonales){

        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, type);
            preparedStatement.setString(2, value);
            preparedStatement.setInt(3,idDatosPersonales);
            return preparedStatement;
        },keyHolder);
        Integer id = (Integer) keyHolder.getKeys()
                .entrySet().stream()
                .filter(m  -> m.getKey().equalsIgnoreCase("idcontactos"))
                .map(Map.Entry::getValue)
                .findFirst().orElse(null);
        Contactos contactos = new Contactos();
        contactos.setTipo(type);
        contactos.setValor(value);
        contactos.setIdDatosPersonales(idDatosPersonales);
        contactos.setIdContacto(id);
        return contactos;
    }

}
