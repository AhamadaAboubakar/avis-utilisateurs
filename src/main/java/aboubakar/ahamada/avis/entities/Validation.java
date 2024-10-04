package aboubakar.ahamada.avis.entities;

import jakarta.persistence.*;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@Entity
@Table(name = "validation")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Validation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Instant creation;
    private Instant expiration;
    private Instant activation;
    private String code; // Code d'activation que le recevra pour valider son mail.
    @OneToOne(cascade = CascadeType.ALL)
    private Utilisateur utilisateur;

}
