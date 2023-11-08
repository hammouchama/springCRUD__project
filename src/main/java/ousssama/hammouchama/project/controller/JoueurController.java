package ousssama.hammouchama.project.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ousssama.hammouchama.project.entities.Joueur;
import ousssama.hammouchama.project.service.JoueurService;

import java.util.List;

@RestController
@AllArgsConstructor
public class JoueurController {
    JoueurService joueurService;

    @GetMapping("joueur")
    public ResponseEntity<List<Joueur>> getAllJoueurs(){
        return new ResponseEntity<>(joueurService.gellAlljoueurs(), HttpStatus.OK);
    }
    @GetMapping("joueur/{id}")
    public ResponseEntity<Joueur> getJoueur(@PathVariable long id){
        return new ResponseEntity<>(joueurService.getjoueur(id),HttpStatus.OK);
    }
    @PostMapping("joueur")
    public ResponseEntity<Joueur> addJoueur(@RequestBody Joueur joueur){
        return  new ResponseEntity<>(joueurService.addjoueur(joueur),HttpStatus.CREATED);
    }
    @PutMapping("joueur/{id}")
    public ResponseEntity<Joueur> updateJoueur(@PathVariable long id,@RequestBody Joueur joueur){
        return  new ResponseEntity<>(joueurService.updatejoueur(id,joueur),HttpStatus.OK);
    }
    @DeleteMapping("joueur/{id}")
    public ResponseEntity<String> deleteEquip(@PathVariable long id){
        joueurService.deletejoueur(id);
        return new ResponseEntity<>("Joueur deleted successfully!",HttpStatus.OK);
    }
    @PutMapping("joueur/{id}/equipe/{equipeId}")
    public ResponseEntity<Joueur> assignedEquipe(@PathVariable long id,@PathVariable long equipeId){
        return new ResponseEntity<>(joueurService.ssignedJoueurToEquipe(equipeId,id),HttpStatus.OK);
    }
    @GetMapping("joueur/equipe/{equipeName}")
    public ResponseEntity<List<Joueur>> getJoueurByEquipeName(@PathVariable String equipeName){
        return new ResponseEntity<>(joueurService.getJoueurByEquipeName(equipeName),HttpStatus.OK);
    }
    @GetMapping("joueur/poste/{poste}/equipe/{equipeName}")
    public ResponseEntity<List<Joueur>> getJoueurByPosteAndEquipeName(@PathVariable String poste,@PathVariable String equipeName){
        return new ResponseEntity<>(joueurService.getJoueurByPostAndEquipeName(poste,equipeName),HttpStatus.OK);
    }
}
