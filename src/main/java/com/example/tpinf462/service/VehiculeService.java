package com.example.tpinf462.service;

import com.example.tpinf462.dto.VehiculeDTO;

import java.util.List;

public interface VehiculeService {
    VehiculeDTO create (VehiculeDTO vehiculeDTO);
    VehiculeDTO uploadvehicule(VehiculeDTO vehiculeDTO);
    void delete(Long id);
    List<VehiculeDTO> findALL();
    VehiculeDTO getByregistration(String registration);
    VehiculeDTO getByprice(double rentalPrice);

}
