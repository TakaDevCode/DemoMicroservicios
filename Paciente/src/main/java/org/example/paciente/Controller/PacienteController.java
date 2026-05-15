package org.example.paciente.Controller;

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
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @GetMapping("")
    public ResponseEntity<List<Paciente>> getAllPacientes(){
        List<Paciente> listado = pacienteService.listarPacientes();
        if(listado.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else{
            return  new ResponseEntity<>(listado, HttpStatus.OK);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Paciente> getPacienteById(@PathVariable int id){
        Paciente buscado = pacienteService.buscarPorId(id);
        if(buscado!=null){
            return new ResponseEntity<>(buscado, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/")
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
