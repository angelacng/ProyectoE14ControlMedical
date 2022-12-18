package com.mintic.apirestg03.servicios;

import java.util.Comparator;
import java.util.List;
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


   public List<AgendaModelo> getAllAgendas(){
      return agendaRepositorio.findAll();
   }

   public List<AgendaModelo> getListAgendasOrdered(){
      List<AgendaModelo> listaAgendas=agendaRepositorio.findAll();
      listaAgendas.sort(Comparator.comparing(AgendaModelo::getFecha));
      return listaAgendas;
  }

   public Optional<AgendaModelo> getAgendaById(String id){
      Optional<AgendaModelo> agenda=agendaRepositorio.findById(id);
      Optional<MedicoModelo> medico=medicoRepositorio.findById(agenda.get().getId_medico());
      agenda.get().setNombremedico(medico.get().getNombre());
      agenda.get().setApellidomedico(medico.get().getApellido());
      agenda.get().setEspecialidad(medico.get().getEspecialidad());

      return agenda;
   }
   
   public AgendaModelo saveAgenda(AgendaModelo agenda){
      Optional<MedicoModelo> medico=medicoRepositorio.findById(agenda.getId_medico());
      agenda.setNombremedico(medico.get().getNombre());
      agenda.setApellidomedico(medico.get().getApellido());
      agenda.setEspecialidad(medico.get().getEspecialidad());
    return agendaRepositorio.save(agenda);
   }

   public String eliminarAgendaPorID(String id){
      if(agendaRepositorio.existsById(id)){
          agendaRepositorio.deleteById(id);               
          return "Agenda eliminada";
      }else{
          return "Documento no encontrado";
      } 
  }

}
