package tn.esprit.saber_aicha_4cce10.service;

import tn.esprit.saber_aicha_4cce10.entities.Maintenance;
import java.util.List;

public interface IMaintenanceService {
    Maintenance create(Maintenance maintenance);
    Maintenance findById(Long id);
    List<Maintenance> findAll();
    Maintenance update(Long id, Maintenance maintenance);
    void deleteById(Long id);
}