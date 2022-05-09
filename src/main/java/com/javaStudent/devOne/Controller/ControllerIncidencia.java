package com.javaStudent.devOne.Controller;

import com.javaStudent.devOne.Entity.FaixaEtaria;
import com.javaStudent.devOne.Entity.Incidencia;
import com.javaStudent.devOne.Entity.Regiao;
import com.javaStudent.devOne.Repo.FaixaEtariaRepos;
import com.javaStudent.devOne.Repo.IncidenciaRepo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
import java.util.Optional;

@RestController
public class ControllerIncidencia {

    private final IncidenciaRepo ocRepository;

    public ControllerIncidencia(IncidenciaRepo ocRepository) {
        this.ocRepository = ocRepository;
    }

    @GetMapping("/incidencia")
    public ResponseEntity<List<Incidencia>> findOcorrencias() {
        List<Regiao> listaOcorrencia = ocRepository.findAll();
        if (listaOcorrencia.isEmpty())
            return new ResponseEntity<>(HttpStatus.OK.NOT_FOUND);

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/ocorrencia/{id}")
    public ResponseEntity<Incidencia> findOcorrenciasById(@PathVariable Long id) {
        Optional<Incidencia> ocorrenciasOptional = ocRepository.findById(id);
        if (ocorrenciasOptional.isPresent()) {
            Incidencia ocorrenciaUnid = (Incidencia) ocorrenciasOptional.get();
            return new ResponseEntity<>(ocorrenciaUnid, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/incidencia/novo")
    public Incidencia newIncidencia(@RequestBody Incidencia newIncidencia) {
        return (Incidencia) ocRepository.save(newIncidencia);

    }
}