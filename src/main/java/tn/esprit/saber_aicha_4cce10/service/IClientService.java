package tn.esprit.saber_aicha_4cce10.service;

import tn.esprit.saber_aicha_4cce10.entities.Client;
import java.util.List;

public interface IClientService {
    Client create(Client client);
    Client findById(Long id);
    List<Client> findAll();
    Client update(Long id, Client client);
    void deleteById(Long id);
}