package com.mintic.apirestg03.servicios;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mintic.apirestg03.modelos.PacienteModelo;
import com.mintic.apirestg03.repositorios.PacienteRepositorio;

@Service
public class PacienteServicio {
    @Autowired
    PacienteRepositorio pacienteRepositorio;

    public PacienteModelo guardarPaciente(PacienteModelo paciente){
        paciente.setNombre(paciente.getNombre().toLowerCase());
        paciente.setApellido(paciente.getApellido().toLowerCase());
        return pacienteRepositorio.save(paciente);
    }

    public List<PacienteModelo> getListPacientesOrden(){
        List<PacienteModelo> listaPacientes=pacienteRepositorio.findAll();
        listaPacientes.sort(Comparator.comparing(PacienteModelo::getNombre));
        return listaPacientes;
    }

    public String eliminarPacientePorID(String id){
        if(pacienteRepositorio.existsById(id)){
            Optional<PacienteModelo> paciente= pacienteRepositorio.findById(id);
            pacienteRepositorio.deleteById(id);               
            return "Paciente " + paciente.get().getNombre()+" Eliminado";
        }else{
            return "Paciente no encontrado";
        } 
    }

}
