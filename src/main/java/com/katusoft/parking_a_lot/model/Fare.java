package com.katusoft.parking_a_lot.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "fare")
public class Fare {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_fare")
    private Long idFare;

    @Column(name = "description")
    private String description;

    @Column(name = "value_per_minute")
    private Double valuePerMinute;

    @OneToMany(mappedBy = "vehicle", cascade = CascadeType.ALL)
    private List<VehType> vehicles;


}
