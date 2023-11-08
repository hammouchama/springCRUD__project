package ousssama.hammouchama.project.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ousssama.hammouchama.project.entities.Arbite;
import ousssama.hammouchama.project.exception.ResourceNotFoundException;
import ousssama.hammouchama.project.repository.ArbiteRepository;

import java.util.List;
import java.util.Optional;
@Service
@AllArgsConstructor
public class ArbiteService {
    ArbiteRepository arbiteRepository;

    public List<Arbite> getAllArbits(){
        return arbiteRepository.findAll();
    }
    public Arbite getArbite(long id){
        return arbiteRepository.findById(id).orElseThrow(   ()->
                new ResourceNotFoundException("Arbite","id",id));
    }
    public Arbite setArbite(Arbite arbite){
        return arbiteRepository.save(arbite);
    }

    public Arbite updateArbite(long id ,Arbite arbite){
        //check the Arbite id is existe in db ot not
        Arbite existingArbite=arbiteRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Arbite","id",id)
        );
        existingArbite.setNom(arbite.getNom());
        existingArbite.setNationalite(arbite.getNationalite());
        //save employee updated
        arbiteRepository.save(existingArbite);
        return existingArbite;
    }
    public void deleteArbite(long id){
        //check the arbite exist or not
      Arbite existingArbte=arbiteRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Arbite","id",id)
        );
        arbiteRepository.deleteById(id);
    }

}
