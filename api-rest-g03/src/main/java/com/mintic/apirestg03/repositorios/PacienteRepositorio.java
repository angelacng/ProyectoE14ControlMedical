package com.mintic.apirestg03.repositorios;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.mintic.apirestg03.modelos.PacienteModelo;

@Repository
public interface PacienteRepositorio extends MongoRepository<PacienteModelo,String>{
    
}
