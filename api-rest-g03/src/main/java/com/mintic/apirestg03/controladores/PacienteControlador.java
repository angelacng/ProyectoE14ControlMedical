package com.mintic.apirestg03.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mintic.apirestg03.modelos.PacienteModelo;
import com.mintic.apirestg03.servicios.PacienteServicio;

@RestController
@RequestMapping("/paciente")
public class PacienteControlador {
    @Autowired
    PacienteServicio pacienteServicio;

    @GetMapping()
    public List<PacienteModelo> getAllPacientes(){
        return pacienteServicio.getListPacientesOrden();
    }

    @PostMapping()
    public PacienteModelo savePaciente(@RequestBody PacienteModelo paciente){
        return pacienteServicio.guardarPaciente(paciente);
    }

    @DeleteMapping("/{id}")
    public String deletePacienteById(@PathVariable("id") String id){
        return pacienteServicio.eliminarPacientePorID(id);
    }
}
