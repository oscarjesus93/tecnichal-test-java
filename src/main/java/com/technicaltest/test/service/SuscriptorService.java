package com.technicaltest.test.service;

import com.technicaltest.test.exceptions.Exceptions;
import com.technicaltest.test.mapper.SuscriptorMapperDto;
import com.technicaltest.test.persistence.Dto.SuscriptorDto;
import com.technicaltest.test.persistence.Dto.SuscriptorUpdateDto;
import com.technicaltest.test.persistence.entity.Suscriptor;
import com.technicaltest.test.persistence.repository.SuscriptorRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SuscriptorService {

    private final SuscriptorRepository repository;
    private final SuscriptorMapperDto mapper;
    private static final String MESSAGE = "La persona no pudo ser registrada";
    private static final String MESSAGE_SUSCRIPTOR = "El suscriptor no pudo ser modificado";

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

    public void Update( Long id, SuscriptorUpdateDto request){

        Optional<Suscriptor> suscriptor = this.repository.findById(id);
        if(suscriptor == null){
            throw new Exceptions(MESSAGE_SUSCRIPTOR, HttpStatus.BAD_REQUEST);
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
