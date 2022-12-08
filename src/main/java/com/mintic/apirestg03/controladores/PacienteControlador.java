package com.mintic.apirestg03.controladores;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mintic.apirestg03.modelos.PacienteModelo;
import com.mintic.apirestg03.servicios.PacienteServicio;

@RestController
@RequestMapping("/pacientes")
@CrossOrigin(origins="*")
public class PacienteControlador {
    @Autowired
    PacienteServicio pacienteServicio;

    @GetMapping()
    public List<PacienteModelo> getAllPacientes(){
        return pacienteServicio.getListPacientesOrden();
    }
    @GetMapping("/{id}")
    public Optional<PacienteModelo> findPacienteById(@PathVariable("id") String id){
        return pacienteServicio.getPacienteById(id);
    }

    @GetMapping("/query") // ejemplo: http://localhost:8080/pacientes/query?apellido=mejia
    public List<PacienteModelo> getPacientesByApellido(@RequestParam("apellido") String apellido){
        return pacienteServicio.getPacientesByApellido(apellido);
    }


    @GetMapping("/ciudad/{ciudad}")
    public List<PacienteModelo> listPacientesCiudad(@PathVariable("ciudad") String ciudad){
        return pacienteServicio.pacientesByCiudad(ciudad);
    }

    @GetMapping("fecha/query")
    public List<PacienteModelo> getPacientesByFechaMenor(@RequestParam("fecha") String fecha){
        LocalDate localdate=LocalDate.parse(fecha);
        return pacienteServicio.pacientePorFechaMenor(localdate);
    }

    @PostMapping()
    public String savePaciente(@RequestBody PacienteModelo paciente){
        return pacienteServicio.guardarPaciente(paciente);
    }

    @DeleteMapping("/{id}")
    public String deletePacienteById(@PathVariable("id") String id){
        return pacienteServicio.eliminarPacientePorID(id);
    }
}
