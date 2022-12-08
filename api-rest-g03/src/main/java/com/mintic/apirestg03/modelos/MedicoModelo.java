package com.mintic.apirestg03.modelos;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document("medicos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MedicoModelo {
    @Id
    private String id;
    private Long ndocumento;
    private String nombre;
    private String apellido;
    private String especialidad;
    private String telefono;
    private String consultorio;
}
