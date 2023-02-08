package com.technicaltest.test.persistence.repository;

import com.technicaltest.test.persistence.entity.Suscripcion;
import com.technicaltest.test.persistence.entity.Suscriptor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface SuscripcionRepository extends JpaRepository<Suscripcion, Long> {

    @Query(value = "select * from suscripcion where id_suscriptor = :idSuscriptor and fecha_alta <= :fechaActual and fecha_baja >= :fechaActual", nativeQuery = true)
    Suscripcion findByFechaAltaAndAndFechaBaja( Long idSuscriptor, LocalDate fechaActual);

    Suscripcion findBySuscriptor(Suscriptor suscriptor);

}
