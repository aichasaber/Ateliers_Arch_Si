package tn.esprit.saber_aicha_4cce10.service.impls;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.saber_aicha_4cce10.entities.Agence;
import tn.esprit.saber_aicha_4cce10.exception.ResourceNotFoundException;
import tn.esprit.saber_aicha_4cce10.repository.IAgenceRepository;
import tn.esprit.saber_aicha_4cce10.service.IAgenceService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AgenceServiceImpl implements IAgenceService {

    private final IAgenceRepository agenceRepository;

    @Override
    public Agence create(Agence agence) {
        if (agence.getId() != null) {
            throw new IllegalArgumentException("Un nouveau agence ne doit pas avoir d'identifiant");
        }
        if (agence.getNom() == null || agence.getNom().isBlank()) {
            throw new IllegalArgumentException("Le nom de l'agence est obligatoire");
        }
        return agenceRepository.save(agence);
    }

    @Override
    public Agence findById(Long id) {
        return agenceRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Agence", id));
    }

    @Override
    public List<Agence> findAll() {
        return agenceRepository.findAll();
    }

    @Override
    public Agence update(Long id, Agence agence) {
        Agence existant = findById(id);
        existant.setNom(agence.getNom());
        existant.setAdresse(agence.getAdresse());
        existant.setTelephone(agence.getTelephone());
        return agenceRepository.save(existant);
    }

    @Override
    public void deleteById(Long id) {
        if (!agenceRepository.existsById(id)) {
            throw new ResourceNotFoundException("Agence", id);
        }
        agenceRepository.deleteById(id);
    }
}