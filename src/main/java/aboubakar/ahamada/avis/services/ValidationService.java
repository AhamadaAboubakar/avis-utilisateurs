package aboubakar.ahamada.avis.services;

import aboubakar.ahamada.avis.entities.Utilisateur;
import aboubakar.ahamada.avis.entities.Validation;
import aboubakar.ahamada.avis.repository.ValidationRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Random;

@Service
@AllArgsConstructor
@Setter
@Getter
public class ValidationService {

    private ValidationRepository validationRepository;
    private NotificationService notificationService;

    public void enregister(Utilisateur utilisateur) {
        Validation validation = new Validation();
        validation.setUtilisateur(utilisateur);
        Instant creation = Instant.now();
        Instant expiration = creation.plus(10, ChronoUnit.MINUTES);

        validation.setExpiration(expiration);
        // Generate random validation code :
        Random random = new Random();
        int randomInteger = random.nextInt(999999);
        String code = String.format("%06d", randomInteger);
        validation.setCode(code);
        this.validationRepository.save(validation);
        this.notificationService.envoyer(validation);
    }
}
