package ousssama.hammouchama.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ousssama.hammouchama.project.entities.Equipe;

import java.util.List;

@Repository
public interface EquipeRepository extends JpaRepository<Equipe,Long> {

    List<Equipe> findByPays(String pays);
     Equipe findByNomEquipe(String name);
}
