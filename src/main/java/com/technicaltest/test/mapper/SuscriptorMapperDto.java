package com.technicaltest.test.mapper;

import com.technicaltest.test.persistence.Dto.SuscriptorDto;
import com.technicaltest.test.persistence.Dto.SuscriptorUpdateDto;
import com.technicaltest.test.persistence.entity.Suscriptor;
import org.springframework.stereotype.Component;

@Component
public class SuscriptorMapperDto implements IMapper<SuscriptorDto, Suscriptor> {

    @Override
    public Suscriptor MapDtoEntity(SuscriptorDto in)  {

        Suscriptor suscriptor = new Suscriptor();

        suscriptor.setApellido(in.getApellido());
        suscriptor.setNombre(in.getNombre());
        suscriptor.setDireccion(in.getDireccion());
        suscriptor.setEmail(in.getEmail());
        suscriptor.setNombreUsuario(in.getNombreUsuario());
        suscriptor.setNumeroDocumento(in.getNumeroDocumento());
        suscriptor.setPassword(in.getPassword());
        suscriptor.setTelefono(in.getTelefono());
        suscriptor.setTipoDocumento(in.getTipoDocumento());

        return suscriptor;
    }

}
