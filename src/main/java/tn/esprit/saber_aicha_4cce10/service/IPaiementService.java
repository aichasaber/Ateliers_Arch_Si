package tn.esprit.saber_aicha_4cce10.service;

import tn.esprit.saber_aicha_4cce10.entities.Paiement;
import java.util.List;

public interface IPaiementService {
    Paiement findById(Long id);
    List<Paiement> findAll();
    // ⚠️ PAS de create, update, delete : la gestion passe par le Contrat
}