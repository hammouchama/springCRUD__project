package ousssama.hammouchama.project.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Matchs {
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idMatch;
    private LocalDate dateMatch;
    private LocalTime heureMatch;
    @ManyToOne
    private Arbite arbite;
    @ManyToOne(cascade =CascadeType.ALL)
    private Stade stade;
    @ManyToOne
    private Equipe equipeA;
    @ManyToOne
    private Equipe equipeB;
}
