package aboubakar.ahamada.avis.services;

import aboubakar.ahamada.avis.entities.Validation;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@Setter
@Getter
@AllArgsConstructor
public class NotificationService {

    JavaMailSender javaMailSender;

    public void envoyer(Validation validation) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("no-replay@ahamada.com");
        message.setTo(validation.getUtilisateur().getEmail());
        message.setSubject("Votre code validation");

        String texte = String.format("Bonjour, <br/> Votre code d'activation est %s; A bientôt",
                validation.getUtilisateur().getUsername(),
                validation.getCode());

        message.setText(texte);

        javaMailSender.send(message);
    }
}
