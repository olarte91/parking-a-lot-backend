package com.katusoft.parking_a_lot.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "vehicle_type")
public class VehType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idVehType;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "fare_id")
    private Fare fare;

    @OneToOne(mappedBy = "vehType")
    private Vehicle vehicle;


}
