package tn.esprit.saber_aicha_4cce10.service.impls;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.saber_aicha_4cce10.entities.Maintenance;
import tn.esprit.saber_aicha_4cce10.exception.ResourceNotFoundException;
import tn.esprit.saber_aicha_4cce10.repository.IMaintenanceRepository;
import tn.esprit.saber_aicha_4cce10.service.IMaintenanceService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MaintenanceServiceImpl implements IMaintenanceService {

    private final IMaintenanceRepository maintenanceRepository;

    @Override
    public Maintenance create(Maintenance maintenance) {
        if (maintenance.getId() != null) {
            throw new IllegalArgumentException("Une nouvelle maintenance ne doit pas avoir d'identifiant");
        }
        if (maintenance.getCout() < 0) {
            throw new IllegalArgumentException("Le coût ne peut pas être négatif");
        }
        return maintenanceRepository.save(maintenance);
    }

    @Override
    public Maintenance findById(Long id) {
        return maintenanceRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Maintenance", id));
    }

    @Override
    public List<Maintenance> findAll() {
        return maintenanceRepository.findAll();
    }

    @Override
    public Maintenance update(Long id, Maintenance maintenance) {
        Maintenance existant = findById(id);
        existant.setDateMaintenance(maintenance.getDateMaintenance());
        existant.setDescription(maintenance.getDescription());
        existant.setCout(maintenance.getCout());
        return maintenanceRepository.save(existant);
    }

    @Override
    public void deleteById(Long id) {
        if (!maintenanceRepository.existsById(id)) {
            throw new ResourceNotFoundException("Maintenance", id);
        }
        maintenanceRepository.deleteById(id);
    }
}