package tn.esprit.saber_aicha_4cce10.service;

import tn.esprit.saber_aicha_4cce10.entities.Vehicule;
import java.util.List;

public interface IVehiculeService {
    Vehicule create(Vehicule vehicule);           // refuse un id non null
    Vehicule findById(Long id);                    // lève ResourceNotFoundException si absent
    List<Vehicule> findAll();
    Vehicule update(Long id, Vehicule vehicule);   // charge l'existant, recopie, save
    void deleteById(Long id);                      // lève ResourceNotFoundException si absent
}