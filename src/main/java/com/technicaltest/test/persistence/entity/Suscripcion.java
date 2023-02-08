package com.technicaltest.test.persistence.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@Entity
@Table(name = "suscripcion")
public class Suscripcion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSuscripcion;
    private LocalDate fechaAlta;
    private LocalDate fechaBaja;
    private String motivoFin;

    @ManyToOne
    @JoinColumn(name = "idSuscriptor")
    private Suscriptor suscriptor;
}
