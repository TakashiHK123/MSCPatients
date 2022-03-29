package com.example.msc.patients.entity;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import javax.persistence.*;
import java.io.Serializable;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "contactos")
public class Contacto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Size(min = 1, max = 18)
    @Column(name = "id_contacto", nullable = false, length = 18)
    private int idContacto;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "tipo", nullable = false, length = 1)
    private String tipo;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "valor", nullable = false, length = 200)
    private String valor;


    @Basic(optional = false)
    @NotNull
    @Size(min = 1 , max = 18)
    @Column(name = "id_datos_personales", nullable = false, length = 18)
    private int idDatosPersonales;


}
