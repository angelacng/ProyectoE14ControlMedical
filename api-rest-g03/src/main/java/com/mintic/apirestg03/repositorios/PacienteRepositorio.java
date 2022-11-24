package com.mintic.apirestg03.repositorios;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.mintic.apirestg03.modelos.PacienteModelo;

@Repository
public interface PacienteRepositorio extends MongoRepository<PacienteModelo,String>{
    List<PacienteModelo> findByApellido(String apellido); //keyword for querymethods   
}
