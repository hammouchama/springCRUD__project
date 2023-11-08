package ousssama.hammouchama.project.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ousssama.hammouchama.project.entities.Equipe;
import ousssama.hammouchama.project.entities.Joueur;
import ousssama.hammouchama.project.exception.ResourceNotFoundException;
import ousssama.hammouchama.project.repository.EquipeRepository;
import ousssama.hammouchama.project.repository.JoueurRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class JoueurService {
    JoueurRepository joueurRepository;
    EquipeRepository equipeRepository;
    public List<Joueur> gellAlljoueurs(){
        return joueurRepository.findAll();
    }
    public Joueur getjoueur(long id){
        return joueurRepository.findById(id).orElseThrow(   ()->
                new ResourceNotFoundException("joueur","id",id));
    }
    public Joueur addjoueur(Joueur joueur){
        return joueurRepository.save(joueur);
    }
    public Joueur updatejoueur(Long id,Joueur joueur){
        Joueur existingjoueur=joueurRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("joueur","id",id)
        );
        existingjoueur.setNomJoueur(joueur.getNomJoueur());
        existingjoueur.setPoste(joueur.getPoste());
        return existingjoueur;
    }
    //delete equpe
    public void deletejoueur(long id){
        Joueur existingjoueur=joueurRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Joueur","id",id)
        );
        joueurRepository.deleteById(id);
    }
    public Joueur ssignedJoueurToEquipe(Long equipeId, Long joueurId){
        Joueur joueur=joueurRepository.findById(joueurId).orElseThrow(
                ()-> new ResourceNotFoundException("Joueur","id",joueurId)
        );
        Equipe equipe=equipeRepository.findById(equipeId).orElseThrow(
                ()-> new ResourceNotFoundException("Equipe","id",equipeId)
        );
       joueur.setEquipe(equipe);
       return joueurRepository.save(joueur);
    }
    public List<Joueur> getJoueurByEquipeName(String equipeNmae){
        Equipe equipe=equipeRepository.findByNomEquipe(equipeNmae);
        if (equipe!=null){
          return joueurRepository.findByEquipe(equipe);
        }else {
            return new ArrayList<>();
        }
    }
    //joueur bu Post and equipe name

     public  List<Joueur> getJoueurByPostAndEquipeName(String poste,String equipeName){
         Equipe equipe=equipeRepository.findByNomEquipe(equipeName);
         if (equipe!=null){
             return joueurRepository.findByPosteAndEquipe(poste,equipe);
         }else {
             return new ArrayList<>();
         }
     }
}
