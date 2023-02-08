package com.technicaltest.test.persistence.repository;

import com.technicaltest.test.persistence.entity.Suscriptor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SuscriptorRepository extends JpaRepository<Suscriptor, Long> {

    Suscriptor findByTipoDocumentoAndNumeroDocumento(String TipoDocumento, String NumeroDocumento);


}
