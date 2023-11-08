package ousssama.hammouchama.project.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;
import ousssama.hammouchama.project.entities.Arbite;
import ousssama.hammouchama.project.entities.Equipe;
import ousssama.hammouchama.project.entities.Matchs;
import ousssama.hammouchama.project.entities.Stade;
import ousssama.hammouchama.project.exception.ResourceNotFoundException;
import ousssama.hammouchama.project.repository.ArbiteRepository;
import ousssama.hammouchama.project.repository.EquipeRepository;
import ousssama.hammouchama.project.repository.MatchRepository;
import ousssama.hammouchama.project.repository.StadeRepository;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class MatchService {

    MatchRepository matchsRepository;
    StadeRepository stadeRepository;
    ArbiteRepository arbiteRepository;
    EquipeRepository equipeRepository;
    public List<Matchs> gellAllmatchs(){
        return matchsRepository.findAll();
    }
    public Matchs getmatch(long id){
        return matchsRepository.findById(id).orElseThrow(   ()->
                new ResourceNotFoundException("matchs","id",id));
    }
    public Matchs addmatch(Matchs matchs){
        return matchsRepository.save(matchs);
    }
    public Matchs updatematch(Long id,Matchs matchs){
        Matchs existingmatchs=matchsRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("matchs","id",id)
        );
        existingmatchs.setDateMatch(matchs.getDateMatch());
        existingmatchs.setHeureMatch(matchs.getHeureMatch());
        return matchsRepository.save(existingmatchs);
    }
    //delete equpe
    public void deletematch(long id){
        Matchs existingmatchs=matchsRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Matchs","id",id)
        );
        matchsRepository.deleteById(id);
    }
    public Matchs assignedStadeToMatch(long stadeId,long matchId){
        Stade stade=stadeRepository.findById(stadeId).orElseThrow(
                ()-> new ResourceNotFoundException("stade","id",stadeId)
        );
        Matchs existingmatchs=matchsRepository.findById(matchId).orElseThrow(
                ()-> new ResourceNotFoundException("matchs","id",matchId)
        );
        existingmatchs.setStade(stade);
        return matchsRepository.save(existingmatchs);
    }
    public Matchs assignedArbiteToMatch(long arbiteId,long matchId){
        Arbite arbite=arbiteRepository.findById(arbiteId).orElseThrow(
                ()-> new ResourceNotFoundException("arbite","id",arbiteId)
        );
        Matchs existingmatchs=matchsRepository.findById(matchId).orElseThrow(
                ()-> new ResourceNotFoundException("matchs","id",matchId)
        );
        existingmatchs.setArbite(arbite);
        return matchsRepository.save(existingmatchs);
    }
    public Matchs assignedEquipesToMatch(long equipeAId ,long equipeBId,long matchId){
        Equipe equipeA=equipeRepository.findById(equipeAId).orElseThrow(
                ()-> new ResourceNotFoundException("EquipeA","id",equipeAId)
        );
        Equipe equipeB=equipeRepository.findById(equipeBId).orElseThrow(
                ()-> new ResourceNotFoundException("EquipeB","id",equipeBId)
        );
        Matchs existingmatchs=matchsRepository.findById(matchId).orElseThrow(
                ()-> new ResourceNotFoundException("matchs","id",matchId)
        );
        existingmatchs.setEquipeA(equipeA);
        existingmatchs.setEquipeB(equipeB);
        return matchsRepository.save(existingmatchs);
    }

    public List<Matchs> getMatchByDate(LocalDate d){
        return matchsRepository.findMatchsByDateMatch(d);
    }
    //Supprimer tous les matchs déjà passés

    public void deleteMatchePasse(){
        LocalDate date=LocalDate.now();
        List<Matchs> matchs=matchsRepository.findByDateMatchBefore(date);
        for (var match:matchs) {
            matchsRepository.deleteById(match.getIdMatch());
        }

    }
}
