package org.example.paciente;

import lombok.extern.slf4j.Slf4j;
import org.example.paciente.Model.Paciente;
import org.example.paciente.Service.PacienteService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
class PacienteApplicationTests {

    @Autowired
    PacienteService servicio;

    @Test
    void contextLoads() {
    }

    @Test
    @DisplayName("Revisando nombre correcto y fecha nula")
    void checkPaciente(){
        Paciente paciente = servicio.buscarPorId(1);
        log.info("Revisando paciente {}",paciente.getNombres());
        assertEquals("Jose",paciente.getNombres());
        assertNull(paciente.getFechaNacimiento());
    }

    @Test
    @DisplayName("Fallo prueba rut")
    void checkPaciente2(){
        Paciente paciente = servicio.buscarPorId(1);
        log.info("Revisando rut de  {}",paciente.getNombres());
        assertEquals("11223344-5",paciente.getRun());
    }

    @Test
    @DisplayName("Revision largo rut")
    void checkLengthRunPaciente(){
        Paciente paciente = servicio.buscarPorId(1);
        log.info("Revisando largo rut de {}",paciente.getNombres());
        assertEquals(10,paciente.getRun().length());

    }

    @Test
    @DisplayName("Verificacion de registros")
    void checkCantidadRegistros(){
        int cantidad = servicio.listarPacientes().size();
        log.info("Verificacion de registros de Pacientes    ");
        assertEquals(2,cantidad);
    }


}
