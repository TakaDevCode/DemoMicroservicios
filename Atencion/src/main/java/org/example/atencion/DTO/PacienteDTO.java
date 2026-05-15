package org.example.atencion.DTO;

import lombok.Data;

import java.util.Date;

@Data
public class PacienteDTO {
    private Integer idPaciente;
    private String run;
    private String nombres;
    private String apellidos;
    private Date fechaNacimiento;
    private String correo;
}
