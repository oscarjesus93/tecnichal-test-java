package com.technicaltest.test.controller;

import com.technicaltest.test.exceptions.Message;
import com.technicaltest.test.persistence.Dto.SuscriptorDto;
import com.technicaltest.test.persistence.Dto.SuscriptorUpdateDto;
import com.technicaltest.test.persistence.entity.Suscriptor;
import com.technicaltest.test.service.SuscriptorService;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/suscriptor")
public class SuscriptorController {

    private final SuscriptorService suscriptorService;

    public SuscriptorController(SuscriptorService suscriptorService) {
        this.suscriptorService = suscriptorService;
    }

    @GetMapping()
    public Suscriptor getByTipoDocumentoAndDocumento(String tipoDocumento, String numeroDocumento){
        return this.suscriptorService.getByTipoDocumentoAndDocumento(tipoDocumento, numeroDocumento);
    }

    @PostMapping
    public Suscriptor crearSuscriptor(@RequestBody SuscriptorDto suscriptor){
       return this.suscriptorService.Create(suscriptor);
    }

    @PutMapping("{id}")
    public ResponseEntity<Object> updateSuscriptor(@PathVariable Long id, @RequestBody SuscriptorUpdateDto update){
        this.suscriptorService.Update(id, update);

        return ResponseEntity.ok(new Message("Datos personales del suscriptor modificados"));
    }
}
