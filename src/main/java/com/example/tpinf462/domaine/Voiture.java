package com.example.tpinf462.domaine;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "voiture")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Voiture implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String model;
    private String make;
    private Float prixVente;
    private Date anneeFabrication;
    private String plaqueImaticulation;

}
