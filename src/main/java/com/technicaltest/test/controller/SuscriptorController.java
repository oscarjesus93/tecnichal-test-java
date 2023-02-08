package com.technicaltest.test.controller;

import com.technicaltest.test.persistence.Dto.SuscriptorDto;
import com.technicaltest.test.persistence.entity.Suscriptor;
import com.technicaltest.test.service.SuscriptorService;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/suscriptor")
public class SuscriptorController {

    private final SuscriptorService suscriptorService;

    public SuscriptorController(SuscriptorService suscriptorService) {
        this.suscriptorService = suscriptorService;
    }

    /**
     * 1. Ingrese los parametros de entrada para buscar un sucriptor por tipo de documento y numero de documento
     * @param tipoDocumento
     * @param numeroDocumento
     * @return
     */
    @GetMapping()
    public Suscriptor getByTipoDocumentoAndDocumento(String tipoDocumento, String numeroDocumento){

        return this.suscriptorService.getByTipoDocumentoAndDocumento(tipoDocumento, numeroDocumento);

    }

    @PostMapping
    public Suscriptor crearSuscriptor(@RequestBody SuscriptorDto suscriptor){

       return this.suscriptorService.Create(suscriptor);

    }
}
