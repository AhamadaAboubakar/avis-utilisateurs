package aboubakar.ahamada.avis.services;

import aboubakar.ahamada.avis.entities.Avis;
import aboubakar.ahamada.avis.repository.AvisRepository;
import org.springframework.stereotype.Service;

@Service

public class AvisService {

    private final AvisRepository avisRepository;

    public AvisService(AvisRepository avisRepository) {
        this.avisRepository = avisRepository;
    }

    public void create(Avis avis) {
        this.avisRepository.save(avis);
    }
}
