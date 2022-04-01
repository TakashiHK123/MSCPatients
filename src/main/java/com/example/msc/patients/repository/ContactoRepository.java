package com.example.msc.patients.repository;

import com.example.msc.patients.entity.Contacto;
import com.example.msc.patients.entity.DatoPersonal;
import com.example.msc.patients.rowMapper.ContactoRowMapper;
import com.example.msc.patients.rowMapper.DatosPersonaleRowMapper;
import com.example.msc.patients.sqlerrorcode.CustomSQLErrorCodeTranslator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;
import java.util.Map;


@Repository
public class ContactoRepository {

    private static final String SQL_INSERT = "INSERT INTO contactos (tipo, valor, id_datos_personales) VALUES (?, ?, ?)";
    private static final String SQL_GET = "SELECT * FROM contactos WHERE id_datos_personales=?";
    private static final String SQL = "SELECT * FROM contactos";
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(final DataSource dataSource){
        jdbcTemplate = new JdbcTemplate(dataSource);
        final CustomSQLErrorCodeTranslator customSQLErrorCodeTranslator = new CustomSQLErrorCodeTranslator();
        jdbcTemplate.setExceptionTranslator(customSQLErrorCodeTranslator);
    }

    public List<Contacto> getAll() {  //ver si se va a usar, si no se elimina
        return jdbcTemplate.query(SQL, new ContactoRowMapper());
    }

    public int addContactoJDBC(Contacto contacto) {
        return jdbcTemplate.update(SQL_INSERT, contacto.getTipo(), contacto.getValor(), contacto.getIdDatosPersonales());
    }

    //Buscar todos los contactos por el idDatosPersonales coincidentes.
    public List<Contacto> getContactos(int idDatosPersonales) {
        List<Contacto> contactos = jdbcTemplate.query(SQL_GET, new Object[] { idDatosPersonales }, new ContactoRowMapper());
        if(contactos!=null){
            return contactos;
        }else{
            return null;
        }
    }
    // retorna el contacto creado con el id generado en la base de datos
    public int addContacto(Contacto contacto){

        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, contacto.getTipo());
            preparedStatement.setString(2, contacto.getValor());
            preparedStatement.setInt(3,contacto.getIdDatosPersonales());
            return preparedStatement;
        },keyHolder);
        Integer id = (Integer) keyHolder.getKeys()
                .entrySet().stream()
                .filter(m  -> m.getKey().equalsIgnoreCase("id_contacto"))
                .map(Map.Entry::getValue)
                .findFirst().orElse(null);

        if(id!=null){
            return id;
        }else{
            return 0;
        }
    }

}
