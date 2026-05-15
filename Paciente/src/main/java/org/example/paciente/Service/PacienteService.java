package org.example.paciente.Service;

import org.example.paciente.Model.Paciente;
import org.example.paciente.Repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    public List<Paciente> listarPacientes(){
        return pacienteRepository.findAll();
    }

    public Paciente buscarPorId(Integer id){
        return pacienteRepository.findById(id).get();
    }

    public Paciente buscarPorRut(String rut){
        return pacienteRepository.findByRun(rut);
    }

    public Paciente agregarPaciente(Paciente nuevo){
        return pacienteRepository.save(nuevo);
    }

    public boolean borrarPaciente(Integer id){
        if(pacienteRepository.existsById(id)){
            pacienteRepository.deleteById(id);
            return true;
        }else{
            return false;
        }
    }

    public Paciente actualizarPaciente(Integer id,Paciente nuevo){
        if(pacienteRepository.existsById(id)){
            Paciente paciente = pacienteRepository.findById(id).get();
            paciente.setRun(nuevo.getRun());
            paciente.setNombres(nuevo.getNombres());
            paciente.setApellidos(nuevo.getApellidos());
            paciente.setFechaNacimiento(nuevo.getFechaNacimiento());
            paciente.setCorreo(nuevo.getCorreo());
            pacienteRepository.save(paciente);
            return paciente;
        }else{
            return null;
        }
    }
}
