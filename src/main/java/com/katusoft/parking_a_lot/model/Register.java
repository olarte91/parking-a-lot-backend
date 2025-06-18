package com.katusoft.parking_a_lot.model;

import java.time.LocalDateTime;
import java.util.List;

import com.katusoft.parking_a_lot.utils.ParkingSpotStatus;

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

@Entity
@Table(name = "register")
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
    private ParkingSpotStatus status;

    @ManyToOne
    @JoinColumn(name = "vehicle_license_plate")
    private Vehicle vehicle;

    @ManyToOne
    @JoinColumn(name = "entrance_user_id")
    private AppUser userEntrance;

    @ManyToOne
    @JoinColumn(name = "departure_user_id")
    private AppUser userDeparture;

    @OneToMany(mappedBy = "register", cascade = CascadeType.ALL)
    private List<ParkingSpace> parkingSpaces;

}
