package org.example.paciente.Repository;

import org.example.paciente.Model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente,Integer> {
    //Custom Queries
    Paciente findByRun(String run);
}
