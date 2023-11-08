package ousssama.hammouchama.project.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ousssama.hammouchama.project.entities.Stade;
import ousssama.hammouchama.project.exception.ResourceNotFoundException;
import ousssama.hammouchama.project.repository.StadeRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class StadeService {
    StadeRepository stadeRepository;
    MatchService matchService;
    public List<Stade> gellAllstade(){
        return stadeRepository.findAll();
    }
    public Stade getstade(long id){
        return stadeRepository.findById(id).orElseThrow(   ()->
                new ResourceNotFoundException("stade","id",id));
    }
    public Stade addstade(Stade stade){
        return stadeRepository.save(stade);
    }
    public Stade updatestade(Long id,Stade stade){
        Stade existingstade=stadeRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("stade","id",id)
        );
        existingstade.setNomStade(stade.getNomStade());
        existingstade.setVille(stade.getVille());
        return existingstade;
    }
    //delete equpe
    public void deletestade(long id){
        Stade existingstade=stadeRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Stade","id",id)
        );
        stadeRepository.deleteById(id);
    }
    public Stade getStadeByMatchId(long id){
        return matchService.getmatch(id).getStade();
    }

}
