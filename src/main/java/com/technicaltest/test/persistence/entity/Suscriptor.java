package com.technicaltest.test.persistence.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "suscriptor")
public class Suscriptor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_suscriptor")
    private Long idSuscriptor;
    private String nombre;
    private String apellido;

    @Column(name = "numero_documento")
    private String numeroDocumento;

    @Column(name = "tipo_documento")
    private String tipoDocumento;
    private String direccion;
    private String telefono;
    private String email;

    @Column(name = "nombre_usuario")
    private String nombreUsuario;
    private String password;

}
