package com.katusoft.parking_a_lot.model;

import java.util.ArrayList;
import java.util.List;

import com.katusoft.parking_a_lot.utils.FareType;

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

    @Column(name = "type")
    private FareType type;

    @Column(name = "value_per_minute")
    private Double valuePerMinute;

    @OneToMany(mappedBy = "fare", cascade = CascadeType.ALL)
    private List<VehType> vehicles = new ArrayList<>();

}
