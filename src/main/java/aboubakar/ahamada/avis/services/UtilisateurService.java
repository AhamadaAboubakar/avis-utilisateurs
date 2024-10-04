package aboubakar.ahamada.avis.services;

import aboubakar.ahamada.avis.TypeDeRole;
import aboubakar.ahamada.avis.entities.Role;
import aboubakar.ahamada.avis.entities.Utilisateur;
import aboubakar.ahamada.avis.repository.UtilisateurRepository;
import lombok.AllArgsConstructor;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
@Getter
@Setter
public class UtilisateurService {

    private UtilisateurRepository utilisateurRepository;
    private BCryptPasswordEncoder passwordEncoder;
    private ValidationService validationService;

    public void inscription(Utilisateur utilisateur) {
        if (!utilisateur.getEmail().contains("@")) {
            throw new RuntimeException("Vôtre adresse mail est invalid");
        }
        if (!utilisateur.getEmail().contains(".")) {
            throw new RuntimeException("Vôtre adresse mail est invalid");
        }
        Optional<Utilisateur> utilisateurOptional = this.utilisateurRepository.findByEmail(utilisateur.getEmail());
        if (utilisateurOptional.isPresent()) {
            throw new RuntimeException("Cette adresse mail est déjà utilisé. Merci de réessayer avec une autre.");
        }
        String mdpCripte = this.passwordEncoder.encode(utilisateur.getPassword());
        utilisateur.setMdp(mdpCripte);
        Role roleUtilisateur = new Role();
        roleUtilisateur.setLibelle(TypeDeRole.UTILISATEUR);
        utilisateur.setRole(roleUtilisateur);
        utilisateur = this.utilisateurRepository.save(utilisateur);
        //this.validationService.enregister(utilisateur);
    }

}

