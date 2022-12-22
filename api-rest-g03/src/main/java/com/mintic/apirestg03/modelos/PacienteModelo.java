package com.mintic.apirestg03.modelos;

import java.time.LocalDate;
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
    private LocalDate fnacimiento;
    private String tiposangre;
    //private String sexo;
    //private String eps;
    private List<String> alergias; //ej: ["acetaminofen","almendras"]
    private Object ubicacion; //ej: ubicacion:{ciudad: "Bucaramanga",departamento:"Santander",direccion:"Calle 43 #34-5"}
    private String telefono;
    private String contacto; //contacto familiar/persona responsable
      
}
