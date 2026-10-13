package tn.esprit.saber_aicha_4cce10.service.impls;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.saber_aicha_4cce10.entities.Equipement;
import tn.esprit.saber_aicha_4cce10.exception.ResourceNotFoundException;
import tn.esprit.saber_aicha_4cce10.repository.IEquipementRepository;
import tn.esprit.saber_aicha_4cce10.service.IEquipementService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EquipementServiceImpl implements IEquipementService {

    private final IEquipementRepository equipementRepository;

    @Override
    public Equipement create(Equipement equipement) {
        if (equipement.getId() != null) {
            throw new IllegalArgumentException("Un nouvel équipement ne doit pas avoir d'identifiant");
        }
        if (equipement.getNom() == null || equipement.getNom().isBlank()) {
            throw new IllegalArgumentException("Le nom de l'équipement est obligatoire");
        }
        return equipementRepository.save(equipement);
    }

    @Override
    public Equipement findById(Long id) {
        return equipementRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Equipement", id));
    }

    @Override
    public List<Equipement> findAll() {
        return equipementRepository.findAll();
    }

    @Override
    public Equipement update(Long id, Equipement equipement) {
        Equipement existant = findById(id);
        existant.setNom(equipement.getNom());
        existant.setDescription(equipement.getDescription());
        return equipementRepository.save(existant);
    }

    @Override
    public void deleteById(Long id) {
        if (!equipementRepository.existsById(id)) {
            throw new ResourceNotFoundException("Equipement", id);
        }
        equipementRepository.deleteById(id);
    }
}