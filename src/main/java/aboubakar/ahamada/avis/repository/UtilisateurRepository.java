package aboubakar.ahamada.avis.repository;

import aboubakar.ahamada.avis.entities.Utilisateur;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UtilisateurRepository extends CrudRepository<Utilisateur, Integer> {
    Optional<Utilisateur> findByEmail(String email);
}
