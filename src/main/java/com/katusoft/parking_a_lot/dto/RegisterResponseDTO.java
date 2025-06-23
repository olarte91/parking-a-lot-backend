package com.katusoft.parking_a_lot.dto;

import java.time.LocalDateTime;

import com.katusoft.parking_a_lot.utils.ParkingType;

import lombok.Data;

@Data
public class RegisterResponseDTO {

    private Long id;
    private String licensePlate;
    private ParkingType vehicleType;
    private LocalDateTime dateTimeEntrance;
    private LocalDateTime dateTimeDeparture;
    private Integer parkingSpaceNumber;
    private Double totalAmount;
    

}
