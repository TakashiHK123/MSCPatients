package com.example.msc.patients.entity;



import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "pacientes")
public class Paciente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Size(min = 1, max = 18)
    @Column(name = "id_paciente", nullable = false, length = 18)
    private int idPaciente;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 18)
    @Column(name = "id_datos_personales", nullable = false, length = 18)
    private int idDatosPersonales;

    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_ingreso", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaIngreso;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "estado", nullable = false, length = 1)
    private String estado;


}
