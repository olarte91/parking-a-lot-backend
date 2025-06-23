package com.katusoft.parking_a_lot.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class RegisterRequestDTO {

    private String licensePlate;
    private Long parkingSpaceNumber;
    private LocalDateTime dateTimeEntrance;
    private Long vehicleType; 
}
