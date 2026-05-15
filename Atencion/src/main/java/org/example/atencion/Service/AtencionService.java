package org.example.atencion.Service;

import org.example.atencion.Client.PacienteClient;
import org.example.atencion.DTO.PacienteDTO;
import org.example.atencion.Model.Atencion;
import org.example.atencion.Repository.AtencionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AtencionService {

    @Autowired
    private AtencionRepository atencionRepository;
    @Autowired
    private PacienteClient pacienteClient;

    public List<Atencion> listarAtenciones(){
        return atencionRepository.findAll();
    }

    public Atencion buscarPorId(int id){
        return atencionRepository.findById(id).get();
    }

    public List<Atencion> buscarPorIdPaciente(int idPaciente){
        pacienteClient.getPaciente(idPaciente);
        return atencionRepository.findAllByIdPaciente(idPaciente);
    }

    public Atencion agregar(Atencion nueva){
        PacienteDTO paciente = pacienteClient.getPaciente(nueva.getIdPaciente());
        System.out.println("Agregando registro atencion para paciente: "+paciente.getNombres());
        return atencionRepository.save(nueva);
    }

    public boolean eliminar(int id){
        Atencion atencion = buscarPorId(id);
        if(atencion!=null){
            atencionRepository.delete(atencion);
            return true;
        }else{
            return false;
        }
    }

    public Atencion updateAtencion(int id, Atencion atencion){
        Atencion buscado =  buscarPorId(id);
        if(buscado!=null){
            buscado.setFechaAtencion(atencion.getFechaAtencion());
            buscado.setHoraAtencion(atencion.getHoraAtencion());
            buscado.setCosto(atencion.getCosto());
            buscado.setComentario(atencion.getComentario());
            buscado.setIdPaciente(atencion.getIdPaciente());
            atencionRepository.save(buscado);
            return buscado;
        }else{
            return null;
        }
    }

}
