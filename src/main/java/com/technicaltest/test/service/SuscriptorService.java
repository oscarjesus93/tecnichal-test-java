package com.technicaltest.test.service;

import com.technicaltest.test.persistence.repository.SuscriptorRepository;
import org.springframework.stereotype.Service;

@Service
public class SuscriptorService {

    private final SuscriptorRepository repository;

    public SuscriptorService(SuscriptorRepository repository){
        this.repository = repository;
    }



}
