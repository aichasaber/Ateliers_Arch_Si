package tn.esprit.saber_aicha_4cce10.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.saber_aicha_4cce10.entities.Client;

public interface IClientRepository extends JpaRepository<Client, Long> {
}