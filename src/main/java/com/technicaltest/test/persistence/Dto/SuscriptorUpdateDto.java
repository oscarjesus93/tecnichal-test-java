package com.technicaltest.test.persistence.Dto;

import lombok.Data;

@Data
public class SuscriptorUpdateDto {

    private String nombre;
    private String apellido;
    private String direccion;
    private String telefono;
    private String email;
    private String nombreUsuario;
    private String password;

}
