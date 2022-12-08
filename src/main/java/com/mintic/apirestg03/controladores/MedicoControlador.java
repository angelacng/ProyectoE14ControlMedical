package com.mintic.apirestg03.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mintic.apirestg03.modelos.MedicoModelo;
import com.mintic.apirestg03.servicios.MedicoServicio;

@RestController
@RequestMapping("/medicos")
public class MedicoControlador {
    @Autowired
    MedicoServicio medicoServicio;

    @GetMapping()
    public List<MedicoModelo> getAllMedicos(){
        return medicoServicio.getAllMedicos();
    }

    @PostMapping()
    public MedicoModelo saveMedico(@RequestBody MedicoModelo medico){
        return medicoServicio.saveMedico(medico);
    }
}
