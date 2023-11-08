package ousssama.hammouchama.project.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ousssama.hammouchama.project.entities.Equipe;
import ousssama.hammouchama.project.service.EquipeService;

import java.util.List;

@RestController
@AllArgsConstructor
public class EquipeController {
    EquipeService equipeService;

    @GetMapping("equipe")
    public ResponseEntity<List<Equipe>> getAllEquipes(){
        return new ResponseEntity<>(equipeService.gellAllEquipes(), HttpStatus.OK);
    }
    @GetMapping("equipe/{id}")
    public ResponseEntity<Equipe> getEquipe(@PathVariable long id){
        return new ResponseEntity<>(equipeService.getEquipe(id),HttpStatus.OK);
    }
    @PostMapping("equipe")
    public ResponseEntity<Equipe> addEquipe(@RequestBody Equipe equipe){
        return  new ResponseEntity<>(equipeService.addEquipe(equipe),HttpStatus.CREATED);
    }
    @PutMapping("equipe/{id}")
    public ResponseEntity<Equipe> updateEquipe(@PathVariable long id,@RequestBody Equipe equipe){
        return  new ResponseEntity<>(equipeService.updateEquipe(id,equipe),HttpStatus.OK);
    }
    @DeleteMapping("equipe/{id}")
    public ResponseEntity<String> deleteEquip(@PathVariable long id){
        equipeService.deleteEquipe(id);
        return new ResponseEntity<>("Equipe deleted successfully!",HttpStatus.OK);
    }
    @GetMapping("equipe/pays/{pays}")
    public ResponseEntity<List<Equipe>> getMarocEquips(@PathVariable String pays){
        return new ResponseEntity<>(equipeService.getEquipeByPays(pays),HttpStatus.OK);
    }
    @GetMapping("equipes/match/{id}")
    public ResponseEntity<List<Equipe>> getEquipesOfMatch(@PathVariable long id){
        return  new ResponseEntity<>(equipeService.getEquipeByMatchId(id),HttpStatus.OK);
    }
}
