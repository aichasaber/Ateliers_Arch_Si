package tn.esprit.saber_aicha_4cce10.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.saber_aicha_4cce10.entities.Vehicule;

public interface IVehiculeRepository extends JpaRepository<Vehicule, Long> {
}