package tn.esprit.saber_aicha_4cce10.service.impls;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.saber_aicha_4cce10.entities.Paiement;
import tn.esprit.saber_aicha_4cce10.exception.ResourceNotFoundException;
import tn.esprit.saber_aicha_4cce10.repository.IPaiementRepository;
import tn.esprit.saber_aicha_4cce10.service.IPaiementService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PaiementServiceImpl implements IPaiementService {

    private final IPaiementRepository paiementRepository;

    @Override
    public Paiement findById(Long id) {
        return paiementRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Paiement", id));
    }

    @Override
    public List<Paiement> findAll() {
        return paiementRepository.findAll();
    }
}