package ousssama.hammouchama.project.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ousssama.hammouchama.project.entities.Arbite;
import ousssama.hammouchama.project.entities.Equipe;
import ousssama.hammouchama.project.entities.Joueur;
import ousssama.hammouchama.project.entities.Matchs;
import ousssama.hammouchama.project.exception.ResourceNotFoundException;
import ousssama.hammouchama.project.repository.EquipeRepository;
import ousssama.hammouchama.project.repository.JoueurRepository;
import ousssama.hammouchama.project.repository.MatchRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class EquipeService {
    EquipeRepository equipeRepository;
    MatchRepository matchRepository;
    public List<Equipe> gellAllEquipes(){
        return equipeRepository.findAll();
    }
    public Equipe getEquipe(long id){
        return equipeRepository.findById(id).orElseThrow(   ()->
                new ResourceNotFoundException("Equipe","id",id));
    }
    public Equipe addEquipe(Equipe equipe){
        return equipeRepository.save(equipe);
    }
    public Equipe updateEquipe(Long id,Equipe equipe){
        Equipe existingEquipe=equipeRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Equipe","id",id)
        );
        existingEquipe.setNomEquipe(equipe.getNomEquipe());
        existingEquipe.setPays(equipe.getPays());
        return existingEquipe;
    }
    //delete equpe
    public void deleteEquipe(long id){
        Equipe existingEquipe=equipeRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("equipe","id",id)
        );
        equipeRepository.deleteById(id);
    }
    public List<Equipe> getEquipeByPays(String pays){
        return equipeRepository.findByPays(pays);
    }
    //les quepe d'une match
    public List<Equipe> getEquipeByMatchId(long matchId){
        Matchs existingmatch=matchRepository.findById(matchId).orElseThrow(
                ()-> new ResourceNotFoundException("equipe","id",matchId)
        );
        List<Equipe> equipes=new ArrayList<>();
        equipes.add(existingmatch.getEquipeA());
        equipes.add(existingmatch.getEquipeB());
        return equipes;
    }

}
