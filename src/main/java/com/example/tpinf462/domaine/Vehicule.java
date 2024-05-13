package com.example.tpinf462.domaine;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "vehicule")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vehicule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String registratioNumber;
    private String model;
    private String make;
    private LocalDate year;
    private double rentalPrice;
    }
