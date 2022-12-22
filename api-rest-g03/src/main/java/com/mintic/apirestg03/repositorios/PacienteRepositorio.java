package com.mintic.apirestg03.repositorios;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.mintic.apirestg03.modelos.PacienteModelo;

@Repository
public interface PacienteRepositorio extends MongoRepository<PacienteModelo,String>{
    List<PacienteModelo> findByApellido(String apellido); //keyword for querymethods   

    @Query("{'direccion.ciudad':?0}")
    List<PacienteModelo> buscarPorCiudad(String ciudad);

    @Query("{fnacimiento:{$lt:?0}}")
    List<PacienteModelo>buscarPacientesMenoresDeFecha(LocalDate fecha);

    Boolean existsByNdocumento(long ndocumento);

    Optional<PacienteModelo> findByNdocumento(long ndocumento);

    //long countByNdocumento(long ndocumento);

    //List<PacienteModelo> findByFnacimientoAfter(LocalDate date);//keywords for query

}
