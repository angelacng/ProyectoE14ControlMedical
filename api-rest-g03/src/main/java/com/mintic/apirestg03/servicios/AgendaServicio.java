package com.mintic.apirestg03.servicios;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mintic.apirestg03.modelos.AgendaModelo;
import com.mintic.apirestg03.modelos.MedicoModelo;
import com.mintic.apirestg03.repositorios.AgendaRepositorio;
import com.mintic.apirestg03.repositorios.MedicoRepositorio;

@Service
public class AgendaServicio {
   @Autowired
   AgendaRepositorio agendaRepositorio;
   @Autowired
   MedicoRepositorio medicoRepositorio; 

   public Optional<AgendaModelo> getAgendaById(String id){
      Optional<AgendaModelo> agenda=agendaRepositorio.findById(id);
      Optional<MedicoModelo> medico=medicoRepositorio.findById(agenda.get().getId_medico());
      agenda.get().setNombremedico(medico.get().getNombre());
      agenda.get().setEspecialidad(medico.get().getEspecialidad());

      return agenda;
   }
   
   public AgendaModelo saveAgenda(AgendaModelo agenda){
    return agendaRepositorio.save(agenda);
   }

}
