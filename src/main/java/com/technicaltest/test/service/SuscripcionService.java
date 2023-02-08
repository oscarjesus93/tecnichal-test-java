package com.technicaltest.test.service;

import com.technicaltest.test.persistence.repository.SuscripcionRepository;
import org.springframework.stereotype.Service;

@Service
public class SuscripcionService {

    private final SuscripcionRepository repository;

    public SuscripcionService(SuscripcionRepository repository) {
        this.repository = repository;
    }
}
