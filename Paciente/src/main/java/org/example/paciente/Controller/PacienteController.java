package org.example.paciente.Controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.example.paciente.Model.Paciente;
import org.example.paciente.Service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/pacientes")
@Tag(name="API Paciente",description = "API para la gestion de pacientes")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;


    @GetMapping("")
    @Operation(summary ="Obtener todos los pacientes",description = "Endpoint permite consultar todos los pacientes")
    @ApiResponse(responseCode="200",description = "Consulta exitosa , se entrega la lista de pacientes")
    @ApiResponse(responseCode="204",description = "Consulta exitosa , pero no se encontraron datos")
    public ResponseEntity<List<Paciente>> getAllPacientes(){
        List<Paciente> listado = pacienteService.listarPacientes();
        if(listado.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else{
            return  new ResponseEntity<>(listado, HttpStatus.OK);
        }
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtiene paciente segun su ID")
    public ResponseEntity<Paciente> getPacienteById(@Parameter(description = "ID del paciente a consultar") @PathVariable int id){
        Paciente buscado = pacienteService.buscarPorId(id);
        if(buscado!=null){
            return new ResponseEntity<>(buscado, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/")
    @Operation(summary = "Permite agregar paciente")
    @ApiResponse(responseCode = "201",description = "Paciente agregado con exito en el sistema ")
    public ResponseEntity<Paciente> createPaciente(@RequestBody @Valid Paciente paciente){
        Paciente nuevo = pacienteService.agregarPaciente(paciente);
        if(nuevo!=null){
            return new ResponseEntity<>(nuevo, HttpStatus.CREATED);
        }else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePaciente(@PathVariable int id){
        boolean res = pacienteService.borrarPaciente(id);
        if(res){
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping
    public ResponseEntity<Paciente> updatePaciente(@PathVariable int id, @RequestBody @Valid Paciente nuevo){
        Paciente actualizado = pacienteService.actualizarPaciente(id, nuevo);
        if(actualizado!=null){
            return new ResponseEntity<>(actualizado, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
