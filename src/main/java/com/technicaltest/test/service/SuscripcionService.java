package com.technicaltest.test.service;

import com.technicaltest.test.exceptions.Exceptions;
import com.technicaltest.test.persistence.Dto.SuscripcionDto;
import com.technicaltest.test.persistence.entity.Suscripcion;
import com.technicaltest.test.persistence.entity.Suscriptor;
import com.technicaltest.test.persistence.repository.SuscripcionRepository;
import com.technicaltest.test.persistence.repository.SuscriptorRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class SuscripcionService {

    private final SuscripcionRepository repository;
    private final SuscriptorRepository suscriptorRepository;
    private final static String MESSAGE_SUSCRIPTOR_ACTIVO = "El suscriptor tiene una suscripción vigente";
    private final static String MESSAGE_SUSCRIPTOR_NOT_FOUND = "El suscriptor no se encuentra registrado";
    private final static String MESSAGE = "El suscriptor no tiene suscripcion activa";

    public SuscripcionService(SuscripcionRepository repository, SuscriptorRepository suscriptorRepository) {
        this.repository = repository;
        this.suscriptorRepository = suscriptorRepository;
    }

    public Suscripcion Create(SuscripcionDto request){

        //consultados que no tenga suscripciones activas el suscriptor

        Suscripcion suscripcionActiva = this.repository.findByFechaAltaAndAndFechaBaja(request.getIdSuscriptor(), LocalDate.now());

        if(suscripcionActiva != null){
            throw new Exceptions(MESSAGE_SUSCRIPTOR_ACTIVO, HttpStatus.BAD_REQUEST);
        }

        Optional<Suscriptor> suscriptor = this.suscriptorRepository.findById(request.getIdSuscriptor());


        if(suscriptor.isEmpty()){
            throw new Exceptions(MESSAGE_SUSCRIPTOR_NOT_FOUND, HttpStatus.BAD_REQUEST);
        }

        Suscripcion suscripcion = new Suscripcion();
        suscripcion.setSuscriptor(suscriptor.get());
        suscripcion.setFechaAlta(LocalDate.now());
        suscripcion.setFechaBaja(LocalDate.now().plusDays(30));

        return this.repository.save(suscripcion);

    }

    public Suscripcion buscarSuscripcionPorSuscriptor(Long id){
        Optional<Suscriptor> suscriptor = this.suscriptorRepository.findById(id);

        if(suscriptor.isEmpty()){
            throw new Exceptions(MESSAGE_SUSCRIPTOR_NOT_FOUND, HttpStatus.BAD_REQUEST);
        }

        Suscriptor suscriptorRes = suscriptor.get();

        Suscripcion suscripcion  = this.repository.findByFechaAltaAndAndFechaBaja(suscriptorRes.getIdSuscriptor(), LocalDate.now());

        if(suscripcion == null){
            throw new Exceptions(MESSAGE, HttpStatus.BAD_REQUEST);
        }

        return suscripcion;
    }
}
