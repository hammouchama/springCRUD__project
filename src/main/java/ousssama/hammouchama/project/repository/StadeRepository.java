package ousssama.hammouchama.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ousssama.hammouchama.project.entities.Stade;

@Repository
public interface StadeRepository extends JpaRepository<Stade,Long> {

}
