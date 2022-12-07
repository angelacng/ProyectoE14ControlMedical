package com.mintic.apirestg03.servicios;

import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mintic.apirestg03.modelos.MedicoModelo;
import com.mintic.apirestg03.repositorios.MedicoRepositorio;

@Service
public class MedicoServicio {
    @Autowired
    MedicoRepositorio medicoRepositorio;

    public List<MedicoModelo> getAllMedicos(){
        List<MedicoModelo> medicos=medicoRepositorio.findAll();
        medicos.sort((Comparator.comparing(MedicoModelo::getEspecialidad)));
        return medicos;
    }

    public MedicoModelo saveMedico(MedicoModelo medico){
        return medicoRepositorio.save(medico);
    }
}
