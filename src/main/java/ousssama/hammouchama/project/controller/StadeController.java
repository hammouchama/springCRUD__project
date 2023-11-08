package ousssama.hammouchama.project.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ousssama.hammouchama.project.entities.Stade;
import ousssama.hammouchama.project.entities.Stade;
import ousssama.hammouchama.project.service.StadeService;

import java.util.List;

@RestController
@AllArgsConstructor
public class StadeController {
   
    StadeService stadeService;

    @GetMapping("stade")
    public ResponseEntity<List<Stade>> getAllStades(){
        return new ResponseEntity<>(stadeService.gellAllstade(), HttpStatus.OK);
    }
    @GetMapping("stade/{id}")
    public ResponseEntity<Stade> getStade(@PathVariable long id){
        return new ResponseEntity<>(stadeService.getstade(id),HttpStatus.OK);
    }
    @PostMapping("stade")
    public ResponseEntity<Stade> addStade(@RequestBody Stade stade){
        return  new ResponseEntity<>(stadeService.addstade(stade),HttpStatus.CREATED);
    }
    @PutMapping("stade/{id}")
    public ResponseEntity<Stade> updateStade(@PathVariable long id,@RequestBody Stade stade){
        return  new ResponseEntity<>(stadeService.updatestade(id,stade),HttpStatus.OK);
    }
    @DeleteMapping("stade/{id}")
    public ResponseEntity<String> deleteEquip(@PathVariable long id){
        stadeService.deletestade(id);
        return new ResponseEntity<>("Stade deleted successfully!",HttpStatus.OK);
    }
    @GetMapping("stade/match/{id}")
    public ResponseEntity<Stade> getStadByMatchId(@PathVariable long id){
        return new ResponseEntity<>(stadeService.getStadeByMatchId(id),HttpStatus.OK);
    }
}
