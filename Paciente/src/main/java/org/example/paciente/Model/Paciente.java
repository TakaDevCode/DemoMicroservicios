package org.example.paciente.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "paciente")
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_paciente")
    private Integer idPaciente;

    @NotBlank(message = "El RUN es obligatorio")
    @Size(max = 10, message = "El RUN no puede superar 10 caracteres")
    @Column(name = "run", nullable = false, unique = true, length = 10)
    private String run;

    @NotBlank(message = "Los nombres son obligatorios")
    @Size(max = 100)
    @Column(name = "nombres", nullable = false, length = 100)
    private String nombres;

    @NotBlank(message = "Los apellidos son obligatorios")
    @Size(max = 100)
    @Column(name = "apellidos", nullable = false, length = 100)
    private String apellidos;

    @Column(name = "fecha_nacimiento", nullable = true)
    private Date fechaNacimiento;

    @Email(message = "El correo no tiene formato válido")
    @Size(max = 100)
    @Column(name = "correo", length = 100)
    private String correo;
}
