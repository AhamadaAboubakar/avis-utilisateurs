package aboubakar.ahamada.avis.entities;

import aboubakar.ahamada.avis.TypeDeRole;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "role")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Enumerated(EnumType.STRING)
    private TypeDeRole libelle;

    public TypeDeRole getLibelle() {
        return libelle;
    }

    public void setLibelle(TypeDeRole libelle) {
        this.libelle = libelle;
    }
}
