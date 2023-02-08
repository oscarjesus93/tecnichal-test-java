package com.technicaltest.test.persistence.repository;

import com.technicaltest.test.persistence.entity.Suscriptor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SuscriptorRepository extends JpaRepository<Suscriptor, Long> {

    Suscriptor findByTipoDocumentoAndNumeroDocumento(String TipoDocumento, String NumeroDocumento);

    List<Suscriptor> findByNumeroDocumentoOrEmailOrNombreUsuario(String numeroDocumento, String email, String nombreUsuario);

}
