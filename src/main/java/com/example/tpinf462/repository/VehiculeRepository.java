package com.example.tpinf462.repository;

import com.example.tpinf462.domaine.Vehicule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository

public interface VehiculeRepository extends JpaRepository<Vehicule, Long> {
    Optional<Vehicule> findByRegistratioNumber(String registrationNumber);
    Optional<Vehicule>findByRentalPrice(double rentalPrice);
}
