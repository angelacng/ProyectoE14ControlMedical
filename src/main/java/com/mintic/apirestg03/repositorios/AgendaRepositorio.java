package com.mintic.apirestg03.repositorios;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.mintic.apirestg03.modelos.AgendaModelo;

@Repository
public interface AgendaRepositorio extends MongoRepository<AgendaModelo,String> {
    
}
