package com.katusoft.parking_a_lot.model;

import java.util.List;

import com.katusoft.parking_a_lot.utils.ParkingType;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "vehicle_type")
@Data
public class VehType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idVehType;

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private ParkingType type;

    @ManyToOne
    @JoinColumn(name = "fare_id")
    private Fare fare;

    @OneToMany(mappedBy = "vehType", cascade = CascadeType.ALL)
    private List<Vehicle> vehicles;


}
