package ousssama.hammouchama.project.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ousssama.hammouchama.project.entities.Arbite;
import ousssama.hammouchama.project.service.ArbiteService;

import java.util.List;

@RestController
@AllArgsConstructor
public class ArbiteController {
    ArbiteService arbiteService;

    @GetMapping("/arbite")
    public List<Arbite> getAllArbits(){
        return arbiteService.getAllArbits();
    }
    @GetMapping("arbite/{id}")
    public ResponseEntity<Arbite> getArbite(@PathVariable long id){
         return new ResponseEntity<>(arbiteService.getArbite(id), HttpStatus.OK) ;
    }
    @PostMapping("arbite")
    public ResponseEntity<Arbite> addArbite(@RequestBody Arbite arbite){
        return new ResponseEntity<>(arbiteService.setArbite(arbite),HttpStatus.CREATED);
    }
    //update arbite
    @PutMapping("/arbite/{id}")
    public ResponseEntity<Arbite> updateArbite(@PathVariable long id,@RequestBody Arbite arbite){
        return  new ResponseEntity<>(arbiteService.updateArbite(id,arbite),HttpStatus.OK);
    }
    //delete arbite
    @DeleteMapping("arbite/{id}")
    public ResponseEntity<String> deleteArbite(@PathVariable long id ){
        arbiteService.deleteArbite(id);
        return new ResponseEntity<String>("Arbite deleted successfully!",HttpStatus.OK);
    }
}
