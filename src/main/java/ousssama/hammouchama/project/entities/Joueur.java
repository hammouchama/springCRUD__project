package ousssama.hammouchama.project.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Joueur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idJoueur;
    private String nomJoueur;
    private String poste;
    @ManyToOne
    private Equipe equipe;
}
