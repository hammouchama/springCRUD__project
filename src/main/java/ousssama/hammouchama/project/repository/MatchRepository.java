package ousssama.hammouchama.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ousssama.hammouchama.project.entities.Matchs;
import ousssama.hammouchama.project.entities.Stade;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface MatchRepository extends JpaRepository<Matchs,Long> {

    List<Matchs> findMatchsByDateMatch(LocalDate date);
    List<Matchs> findByDateMatchBefore(LocalDate date);
}
