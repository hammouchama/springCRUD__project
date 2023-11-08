package ousssama.hammouchama.project.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Stade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idStade;
    private String nomStade;
    private String ville;
}
