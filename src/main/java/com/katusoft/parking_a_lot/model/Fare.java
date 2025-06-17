package com.katusoft.parking_a_lot.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
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

    @OneToOne(mappedBy = "fare")
    private VehType vehType;

}
