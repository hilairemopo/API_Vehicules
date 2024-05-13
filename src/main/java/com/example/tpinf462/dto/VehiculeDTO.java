package com.example.tpinf462.dto;

import java.time.LocalDate;
import lombok.*;
@Data

public class VehiculeDTO {
    private Long id;
    private String registratioNumber;
    private String model;
    private String make;
    private LocalDate year;
    private double rentalPrice;
}
