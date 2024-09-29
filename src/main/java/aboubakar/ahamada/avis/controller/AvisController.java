package aboubakar.ahamada.avis.controller;


import aboubakar.ahamada.avis.entities.Avis;
import aboubakar.ahamada.avis.services.AvisService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RequestMapping("avis")
@RestController
public class AvisController {
    private final AvisService avisService;

    public AvisController(AvisService avisService) {
        this.avisService = avisService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody Avis avis) {
        this.avisService.create(avis);
    }
}
