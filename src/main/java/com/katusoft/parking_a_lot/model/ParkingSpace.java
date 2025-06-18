package com.katusoft.parking_a_lot.model;

import com.katusoft.parking_a_lot.utils.ParkingSpotStatus;
import com.katusoft.parking_a_lot.utils.ParkingType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "parking_space")
public class ParkingSpace {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "code")
    private String code;

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private ParkingType type;

    @Column(name = "location")
    private String location;

    @Column(name = "status")
    private ParkingSpotStatus status;

    @ManyToOne
    @JoinColumn(name = "space_id")
    private Register register;
}
