package com.mintic.apirestg03.controladores;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mintic.apirestg03.modelos.MedicoModelo;
import com.mintic.apirestg03.servicios.MedicoServicio;

@RestController
@RequestMapping("/medicos")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.DELETE,RequestMethod.POST})
public class MedicoControlador {
    @Autowired
    MedicoServicio medicoServicio;

    @GetMapping()
    public List<MedicoModelo> getAllMedicos(){
        return medicoServicio.getAllMedicos();
    }

    @GetMapping("/{id}")
    public Optional<MedicoModelo> findMedicoById(@PathVariable("id") String id){
        return medicoServicio.getMedicoById(id);
    }

    @PostMapping()
    public MedicoModelo saveMedico(@RequestBody MedicoModelo medico){
        return medicoServicio.saveMedico(medico);
    }
}
