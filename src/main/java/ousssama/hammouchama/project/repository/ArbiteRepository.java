package ousssama.hammouchama.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ousssama.hammouchama.project.entities.Arbite;

@Repository
public interface ArbiteRepository extends JpaRepository<Arbite,Long> {

}
