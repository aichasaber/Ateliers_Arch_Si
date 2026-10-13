package tn.esprit.saber_aicha_4cce10.service;

import tn.esprit.saber_aicha_4cce10.entities.Reservation;
import java.util.List;

public interface IReservationService {
    Reservation create(Reservation reservation);
    Reservation findById(Long id);
    List<Reservation> findAll();
    Reservation update(Long id, Reservation reservation);
    void deleteById(Long id);
}