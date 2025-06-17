package com.katusoft.parking_a_lot.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "vehicle")
public class Vehicle {
    @Id
    private String licensePlate;

    @Column( name = "brand")
    private String brand;

    @Column(name = "color")
    private String color;

    @OneToOne
    @JoinColumn(name = "veh_type_id")
    private VehType vehType;

    @OneToMany(mappedBy = "vehicle", cascade = CascadeType.ALL)
    private List<Register> registers;

}
