package com.technicaltest.test.controller;

import com.technicaltest.test.persistence.Dto.SuscripcionDto;
import com.technicaltest.test.persistence.entity.Suscripcion;
import com.technicaltest.test.service.SuscripcionService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/suscripcion")
public class SuscripcionController {

    private final SuscripcionService suscripcionService;

    public SuscripcionController(SuscripcionService suscripcionService) {
        this.suscripcionService = suscripcionService;
    }

    @PostMapping
    public Suscripcion crearSuscripcion(@RequestBody SuscripcionDto request){

        Suscripcion suscripcion = this.suscripcionService.Create(request);
        return suscripcion;

    }
}
