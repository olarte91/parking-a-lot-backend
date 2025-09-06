package com.katusoft.parking_a_lot.model;

import java.time.LocalDateTime;

import com.katusoft.parking_a_lot.enums.RegisterStatus;

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
import lombok.Data;

@Entity
@Table(name = "register")
@Data
public class Register {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "amount")
    private Double amount;

    @Column(name = "date_time_entrance")
    private LocalDateTime dateTimeEntrance;

    @Column(name = "date_time_departure")
    private LocalDateTime dateTimeDeparture;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private RegisterStatus status;

    @ManyToOne
    @JoinColumn(name = "vehicle_license_plate")
    private Vehicle vehicle;

    @ManyToOne
    @JoinColumn(name = "space_id")
    private ParkingSpace parkingSpace;

}
