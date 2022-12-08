package com.mintic.apirestg03.modelos;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document("agendas")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AgendaModelo {
    @Id
    private String id;
    private String id_medico;
    private String nombremedico;
    private String especialidad;
    private LocalDate fecha;
    private List<CitaModelo> citas;//[{id_paciente,hora},{},{}]
    
}
