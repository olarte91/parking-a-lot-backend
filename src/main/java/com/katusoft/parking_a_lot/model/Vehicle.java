package com.katusoft.parking_a_lot.model;

import java.util.List;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "vehicle")
@Data
public class Vehicle {
    @Id
    private String licensePlate;

    @ManyToOne
    @JoinColumn(name = "vehicles")
    private VehType vehType;

    @OneToMany(mappedBy = "vehicle", cascade = CascadeType.ALL)
    private List<Register> registers;

}
