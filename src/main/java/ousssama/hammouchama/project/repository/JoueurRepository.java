package ousssama.hammouchama.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ousssama.hammouchama.project.entities.Equipe;
import ousssama.hammouchama.project.entities.Joueur;

import java.util.List;

@Repository
public interface JoueurRepository extends JpaRepository<Joueur,Long> {

    List<Joueur> findByEquipe(Equipe equipe);
    List<Joueur> findByPosteAndEquipe(String poste,Equipe equipe);
}
