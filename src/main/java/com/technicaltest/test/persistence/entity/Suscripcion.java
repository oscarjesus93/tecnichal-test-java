package com.technicaltest.test.persistence.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "suscripcion")
public class Suscripcion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSuscripcion;
    private LocalDateTime fechaAlta;
    private LocalDateTime fechaBaja;
    private String motivoFin;

    @ManyToOne
    @JoinColumn(name = "idSuscriptor")
    private Suscriptor suscriptor;
}
