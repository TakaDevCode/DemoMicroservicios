package org.example.atencion.Controller;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.example.atencion.Model.Atencion;
import org.example.atencion.Service.AtencionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/atenciones")
@Slf4j
public class AtencionController {
    @Autowired
    private AtencionService atencionService;

    @GetMapping("")
    public ResponseEntity<List<Atencion>> listar() {
        List<Atencion> atenciones = atencionService.listarAtenciones();
        if (atenciones.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(atenciones);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Atencion> buscarporID(@PathVariable Integer id) {
        Atencion atencion = atencionService.buscarPorId(id);
        if (atencion == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(atencion);
        }
    }

    @GetMapping("/paciente/{idPaciente}")
    public ResponseEntity<List<Atencion>> listarPorPaciente(@PathVariable Integer idPaciente) {
        List<Atencion> lista = atencionService.buscarPorIdPaciente(idPaciente);
        if (lista.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(lista);
        }
    }

    @PostMapping("/")
    public ResponseEntity<Atencion> agregar(@RequestBody @Valid Atencion atencion) {
        log.info("Agregando atencion con fecha {}", atencion.getFechaAtencion());
        return ResponseEntity.ok(atencionService.agregar(atencion));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        boolean res =  atencionService.eliminar(id);
        if (res) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Atencion> actualizar(@PathVariable Integer id, @RequestBody @Valid Atencion atencion) {
        Atencion updated = atencionService.updateAtencion(id, atencion);
        if (updated == null) {
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok(updated);
        }
    }
}
