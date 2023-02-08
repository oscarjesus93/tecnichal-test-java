package com.technicaltest.test.controller;

import com.technicaltest.test.persistence.Dto.SuscripcionDto;
import com.technicaltest.test.persistence.entity.Suscripcion;
import com.technicaltest.test.service.SuscripcionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
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

    @GetMapping
    public Suscripcion buscarSuscripcionPorSuscriptor(Long idSuscriptor){
        return this.suscripcionService.buscarSuscripcionPorSuscriptor(idSuscriptor);
    }

}
