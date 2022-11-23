package com.mintic.apirestg03.modelos;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document("pacientes")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PacienteModelo {
    @Id
    private String id;
    private String nombre;
    private String apellido;
    private Long ndocumento;
    private List<String> alergias; //ej: ["acetaminofen","ibuprofeno"]
    private Object direccion; //ej: direccion:{ciudad: "Bucaramanga",departamento:"Santander"}
    
}
