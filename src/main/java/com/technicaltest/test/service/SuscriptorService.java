package com.technicaltest.test.service;

import com.technicaltest.test.exceptions.Exceptions;
import com.technicaltest.test.mapper.SuscriptorMapperDto;
import com.technicaltest.test.persistence.Dto.SuscriptorDto;
import com.technicaltest.test.persistence.Dto.SuscriptorUpdateDto;
import com.technicaltest.test.persistence.entity.Suscriptor;
import com.technicaltest.test.persistence.repository.SuscriptorRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class SuscriptorService {

    private final SuscriptorRepository repository;
    private final SuscriptorMapperDto mapper;
    private static final String MESSAGE = "La persona no pudo ser registrada";
    private static final String MESSAGE_SUSCRIPTOR = "El suscriptor no pudo ser modificado";
    private static final String MESSAGE_SUSCRIPTOR_NOTFOUND = "Suscriptor no encontrado. Desea registrar el suscriptor.?";
    private static final String MESSAGE_FORM_VALIDATE = "Todos los campos son requeridos";

    public SuscriptorService(SuscriptorRepository repository, SuscriptorMapperDto mapper){
        this.repository = repository;
        this.mapper = mapper;
    }

    public Suscriptor getByTipoDocumentoAndDocumento(String tipoDocumento, String numeroDocumento){

        Suscriptor suscriptor = repository.findByTipoDocumentoAndNumeroDocumento(tipoDocumento, numeroDocumento);

        if( suscriptor == null){
            throw new Exceptions(MESSAGE_SUSCRIPTOR_NOTFOUND, HttpStatus.NOT_FOUND);
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

    @Transactional
    public void Update( Long id, SuscriptorUpdateDto request){

        Optional<Suscriptor> suscriptor = this.repository.findById(id);
        if(suscriptor == null){
            throw new Exceptions(MESSAGE_SUSCRIPTOR, HttpStatus.BAD_REQUEST);
        }

        if(request.getNombre().isEmpty()){
            throw new Exceptions(MESSAGE_FORM_VALIDATE, HttpStatus.BAD_REQUEST);
        }

        if(request.getDireccion().isEmpty()){
            throw new Exceptions(MESSAGE_FORM_VALIDATE, HttpStatus.BAD_REQUEST);
        }

        if(request.getEmail().isEmpty()){
            throw new Exceptions(MESSAGE_FORM_VALIDATE, HttpStatus.BAD_REQUEST);
        }

        if(request.getApellido().isEmpty()){
            throw new Exceptions(MESSAGE_FORM_VALIDATE, HttpStatus.BAD_REQUEST);
        }

        if(request.getNombreUsuario().isEmpty()){
            throw new Exceptions(MESSAGE_FORM_VALIDATE, HttpStatus.BAD_REQUEST);
        }

        if(request.getPassword().isEmpty()){
            throw new Exceptions(MESSAGE_FORM_VALIDATE, HttpStatus.BAD_REQUEST);
        }

        if(request.getTelefono().isEmpty()){
            throw new Exceptions(MESSAGE_FORM_VALIDATE, HttpStatus.BAD_REQUEST);
        }

        Suscriptor suscriptorRes = suscriptor.get();

        suscriptorRes.setNombre(request.getNombre());
        suscriptorRes.setApellido(request.getApellido());
        suscriptorRes.setDireccion(request.getDireccion());
        suscriptorRes.setTelefono(request.getTelefono());
        suscriptorRes.setEmail(request.getEmail());
        suscriptorRes.setNombreUsuario(request.getNombreUsuario());
        suscriptorRes.setPassword(request.getPassword());

        this.repository.save(suscriptorRes);

    }


}
