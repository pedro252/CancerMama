package com.javaStudent.devOne.Controller;

import com.javaStudent.devOne.Entity.Regiao;
import com.javaStudent.devOne.Repo.RegiaoRepo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ControllerRegiao {

    private final RegiaoRepo repository;

    public  ControllerRegiao (RegiaoRepo repository){
        this.repository = repository;
    }

    @GetMapping("/regiao") //url que sera usada
    public List<RegiaoRepo> getRegiao(){
        return repository.findAll();
    }

    @GetMapping ("/regiao/{id}")
    public ResponseEntity<?> getRegiaoById(@PathVariable Long id){
        Optional regiaoEscolhidaOptional = repository.findById(id);

        if (regiaoEscolhidaOptional.isPresent()){
            Regiao regiaoEscolhida = (Regiao) regiaoEscolhidaOptional.get();
            return new ResponseEntity<>(regiaoEscolhida, HttpStatus.OK);
        }
        return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/regiao/novo")
    public Regiao putRegiao(@RequestBody Regiao newFaixa){
        return repository.save(newFaixa);
    }

    @DeleteMapping("/regiao/delete/{id}")
    public void deleteRegiao(@PathVariable Long id){
        repository.deleteById(id);
    }
}
