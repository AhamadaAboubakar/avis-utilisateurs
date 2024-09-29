package aboubakar.ahamada.avis.controller;

import aboubakar.ahamada.avis.entities.Utilisateur;
import aboubakar.ahamada.avis.services.UtilisateurService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
public class utilisateurController {

    private static final Logger log = LoggerFactory.getLogger(utilisateurController.class);
    private UtilisateurService utilisateurService;

    @PostMapping(path = "inscription")
    public void inscription(@RequestBody Utilisateur utilisateur) {
        log.info("Inscription");
        utilisateurService.inscription(utilisateur);

    }
}
