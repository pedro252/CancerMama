package com.javaStudent.devOne.Controller;

import com.javaStudent.devOne.Entity.FaixaEtaria;
import com.javaStudent.devOne.Repo.FaixaEtariaRepos;
import com.javaStudent.devOne.Repo.RegiaoRepo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController // retorna um objeto de dominio
public class ControllerFaixaEtaria {

    private final FaixaEtariaRepos fRepository;

    public ControllerFaixaEtaria(FaixaEtariaRepos frepository, FaixaEtariaRepos fRepository){


        this.fRepository = frepository;
    }

    @GetMapping ("/faixaetaria") // mapeamento de solicitações HTTP
    public ResponseEntity<?> findAllFaixaEtaria(){
        try{
            List<FaixaEtaria> lista = fRepository.findAll();
            return new ResponseEntity<>(lista, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/faixaetaria/{id}")
    public ResponseEntity<?> findByIdFaixaEtaria(@PathVariable long id){
        Optional<FaixaEtaria> uniOptional = fRepository.findById(id);
    try {
        if (uniOptional.isPresent()) {
            FaixaEtaria faixaEtariaUnid = (FaixaEtaria) uniOptional.get();
            return new ResponseEntity<>(faixaEtariaUnid, HttpStatus.OK);
        }
    } catch (Exception e){
        e.printStackTrace();
    }
    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping ("/faixaetaria/novo")
    public FaixaEtaria newFaixaEtaria(@RequestBody FaixaEtaria newFaixa){
        return fRepository.save(newFaixa);
    }

    @DeleteMapping ("/faixaetaria/remover/{id}")
    public void deleteFaixaEtaria(@PathVariable long id){
        fRepository.deleteById(id);
    }
}
