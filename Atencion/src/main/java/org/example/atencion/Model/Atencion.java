package org.example.atencion.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name="atencion")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Atencion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "La fecha de atención es obligatoria")
    @Column(name = "fecha_atencion", nullable = false)
    private Date fechaAtencion;

    @NotNull(message = "La hora de atención es obligatoria")
    @Column(name = "hora_atencion", nullable = false)
    private Date horaAtencion;

    @NotNull(message = "El costo es obligatorio")
    @Column(name = "costo", nullable = false)
    private Double costo;

    @NotNull(message = "El id del paciente es obligatorio")
    @Column(name = "id_paciente", nullable = false)
    private Integer idPaciente;

    @Size(max = 200)
    @Column(name = "comentario", length = 200)
    private String comentario;
}
