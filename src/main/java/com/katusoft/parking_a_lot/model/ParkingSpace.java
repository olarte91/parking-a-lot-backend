package com.katusoft.parking_a_lot.model;

import java.util.ArrayList;
import java.util.List;

import com.katusoft.parking_a_lot.utils.ParkingSpotStatus;
import com.katusoft.parking_a_lot.utils.ParkingType;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "parking_space")
@Data
public class ParkingSpace {

    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private ParkingType type;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private ParkingSpotStatus status;

    @OneToMany(mappedBy = "parkingSpace", cascade = CascadeType.ALL)
    private List<Register> registros = new ArrayList<>();
}
