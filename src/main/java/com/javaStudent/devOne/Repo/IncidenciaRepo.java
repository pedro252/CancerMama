package com.javaStudent.devOne.Repo;

import com.javaStudent.devOne.Entity.Incidencia;
import com.javaStudent.devOne.Entity.Regiao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IncidenciaRepo<Inicidencia> extends JpaRepository<Inicidencia, Long> {
}
