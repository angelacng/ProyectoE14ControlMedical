package com.mintic.apirestg03.servicios;

import java.time.LocalDate;
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

    public String guardarPaciente(PacienteModelo paciente){
        paciente.setNombre(paciente.getNombre().toLowerCase());
        paciente.setApellido(paciente.getApellido().toLowerCase());
        boolean estado=paciente.getId()==null || !pacienteRepositorio.existsById(paciente.getId());
        pacienteRepositorio.save(paciente);
        if(estado){
            return "Se guardó el paciente";
        }else{
            return "Se actualizó el paciente";
        }
        
    }

    public List<PacienteModelo> getListPacientesOrden(){
        List<PacienteModelo> listaPacientes=pacienteRepositorio.findAll();
        listaPacientes.sort(Comparator.comparing(PacienteModelo::getNombre));
        return listaPacientes;
    }

    public Optional<PacienteModelo> getPacienteById(String id){
        return pacienteRepositorio.findById(id);
    } 

    public List<PacienteModelo> getPacientesByApellido(String apellido){
        return pacienteRepositorio.findByApellido(apellido);
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

    public List<PacienteModelo> pacientesByCiudad(String ciudad){
        return pacienteRepositorio.buscarPorCiudad(ciudad);
    }

    public List<PacienteModelo> pacientePorFechaMenor(LocalDate fecha){
           return pacienteRepositorio.buscarPacientesMenoresDeFecha(fecha); 
    }

}
