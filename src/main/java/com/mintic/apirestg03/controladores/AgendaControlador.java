package com.mintic.apirestg03.controladores;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mintic.apirestg03.modelos.AgendaModelo;
import com.mintic.apirestg03.servicios.AgendaServicio;

@RestController
@RequestMapping("/agendas")
public class AgendaControlador {
    @Autowired
    AgendaServicio agendaServicio;

    @GetMapping("/{id}")
    public Optional<AgendaModelo> getAgendaById(@PathVariable("id") String id){
        return agendaServicio.getAgendaById(id);
    }

    @PostMapping()
    public AgendaModelo saveAgenda(@RequestBody AgendaModelo agenda){
        return agendaServicio.saveAgenda(agenda);

    }
    
}
