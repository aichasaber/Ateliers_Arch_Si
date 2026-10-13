package tn.esprit.saber_aicha_4cce10.service.impls;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.saber_aicha_4cce10.entities.Vehicule;
import tn.esprit.saber_aicha_4cce10.exception.ResourceNotFoundException;
import tn.esprit.saber_aicha_4cce10.repository.IVehiculeRepository;
import tn.esprit.saber_aicha_4cce10.service.IVehiculeService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VehiculeServiceImpl implements IVehiculeService {

    // ⚠️ LE CHAMP DOIT ÊTRE FINAL pour que @RequiredArgsConstructor génère le constructeur
    private final IVehiculeRepository vehiculeRepository;

    @Override
    public Vehicule create(Vehicule vehicule) {
        if (vehicule.getId() != null) {
            throw new IllegalArgumentException(
                    "Un nouveau véhicule ne doit pas avoir d'identifiant");
        }
        // Règle métier : refuser un tarif négatif
        if (vehicule.getPrixJour() < 0) {
            throw new IllegalArgumentException(
                    "Le prix journalier ne peut pas être négatif");
        }
        return vehiculeRepository.save(vehicule);
    }

    @Override
    public Vehicule findById(Long id) {
        return vehiculeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Vehicule", id));
    }

    @Override
    public List<Vehicule> findAll() {
        return vehiculeRepository.findAll();
    }

    @Override
    public Vehicule update(Long id, Vehicule vehicule) {
        Vehicule existant = findById(id);
        existant.setMarque(vehicule.getMarque());
        existant.setModele(vehicule.getModele());
        existant.setImmatriculation(vehicule.getImmatriculation());
        existant.setPrixJour(vehicule.getPrixJour());
        // Ne PAS toucher : id, agence, reservations, maintenances, equipements
        return vehiculeRepository.save(existant);
    }

    @Override
    public void deleteById(Long id) {
        if (!vehiculeRepository.existsById(id)) {
            throw new ResourceNotFoundException("Vehicule", id);
        }
        vehiculeRepository.deleteById(id);
    }
}