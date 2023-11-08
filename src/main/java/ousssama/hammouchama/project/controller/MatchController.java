package ousssama.hammouchama.project.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ousssama.hammouchama.project.entities.Matchs;
import ousssama.hammouchama.project.service.MatchService;

import java.time.LocalDate;
import java.util.List;

@RestController
@AllArgsConstructor
public class MatchController {
   
    MatchService matchService;

    @GetMapping("match")
    public ResponseEntity<List<Matchs>> getAllMatchss(){
        return new ResponseEntity<>(matchService.gellAllmatchs(), HttpStatus.OK);
    }
    @GetMapping("match/{id}")
    public ResponseEntity<Matchs> getMatchs(@PathVariable long id){
        return new ResponseEntity<>(matchService.getmatch(id),HttpStatus.OK);
    }
    @PostMapping("match")
    public ResponseEntity<Matchs> addMatchs(@RequestBody Matchs matchs){
        return  new ResponseEntity<>(matchService.addmatch(matchs),HttpStatus.CREATED);
    }
    @PutMapping("match/{id}")
    public ResponseEntity<Matchs> updateMatchs(@PathVariable long id,@RequestBody Matchs matchs){
        return  new ResponseEntity<>(matchService.updatematch(id,matchs),HttpStatus.OK);
    }
    @DeleteMapping("match/{id}")
    public ResponseEntity<String> deleteEquip(@PathVariable long id){
        matchService.deletematch(id);
        return new ResponseEntity<>("Matchs deleted successfully!",HttpStatus.OK);
    }
    @PutMapping("match/{id}/stade/{stadeId}")
    public ResponseEntity<Matchs> assignedStade(@PathVariable long id,@PathVariable long stadeId){
        return new ResponseEntity<>(matchService.assignedStadeToMatch(stadeId,id),HttpStatus.OK);
    }
    @PutMapping("match/{id}/arbite/{arbiteId}")
    public ResponseEntity<Matchs> assignedArbite(@PathVariable long id,@PathVariable long arbiteId){
        return new ResponseEntity<>(matchService.assignedArbiteToMatch(arbiteId,id),HttpStatus.OK);
    }
    @PutMapping("match/{id}/equipeA/{equipeAId}/equipeB/{equipeBId}")
    public ResponseEntity<Matchs> assignedEquipes(@PathVariable long id,@PathVariable long equipeAId,@PathVariable long equipeBId){
        return new ResponseEntity<>(matchService.assignedEquipesToMatch(equipeAId,equipeBId,id),HttpStatus.OK);
    }
    //Récupérer les matchs qui sont programmés le ‘28/02/2021’
    @GetMapping("match/date/{date}")
    public ResponseEntity<List<Matchs>> getMatchByDate(@PathVariable LocalDate date){
        return new ResponseEntity<>(matchService.getMatchByDate(date),HttpStatus.OK);
    }
    @DeleteMapping("match/passed")
    public ResponseEntity<String> deletePassedMatchs(){
        matchService.deleteMatchePasse();
        return new ResponseEntity<>("Matchs deleted successfully!",HttpStatus.OK);
    }
}
