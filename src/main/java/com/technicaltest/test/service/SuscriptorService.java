package com.technicaltest.test.service;

import com.technicaltest.test.exceptions.Exceptions;
import com.technicaltest.test.mapper.SuscriptorMapperDto;
import com.technicaltest.test.persistence.Dto.SuscriptorDto;
import com.technicaltest.test.persistence.entity.Suscriptor;
import com.technicaltest.test.persistence.repository.SuscriptorRepository;
import net.bytebuddy.asm.Advice;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SuscriptorService {

    private final SuscriptorRepository repository;
    private final SuscriptorMapperDto mapper;
    private static final String MESSAGE = "La persona no pudo ser registrada";

    public SuscriptorService(SuscriptorRepository repository, SuscriptorMapperDto mapper){
        this.repository = repository;
        this.mapper = mapper;
    }

    public Suscriptor getByTipoDocumentoAndDocumento(String tipoDocumento, String numeroDocumento){

        Suscriptor suscriptor = repository.findByTipoDocumentoAndNumeroDocumento(tipoDocumento, numeroDocumento);

        if( suscriptor == null){
            throw new Exceptions("Suscriptor no encontrado", HttpStatus.NOT_FOUND);
        }

        return suscriptor;
    }

    public Suscriptor Create(SuscriptorDto suscriptorDto){

        List<Suscriptor> suscriptorList = this.repository.findByNumeroDocumentoOrEmailOrNombreUsuario(suscriptorDto.getNumeroDocumento(),
                                                                                            suscriptorDto.getEmail(),
                                                                                            suscriptorDto.getNombreUsuario());

        if(!suscriptorList.isEmpty()){
            throw new Exceptions(MESSAGE, HttpStatus.BAD_REQUEST);
        }

        Suscriptor suscriptor = this.mapper.MapDtoEntity(suscriptorDto);

        return this.repository.save(suscriptor);

    }

}
