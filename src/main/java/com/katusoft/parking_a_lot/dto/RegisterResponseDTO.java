package com.katusoft.parking_a_lot.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class RegisterResponseDTO {

    private Long id;
    private String licensePlate;
    private String vehicleType;
    private LocalDateTime dateTimeEntrance;
    private LocalDateTime dateTimeDeparture;
    private Long parkingSpaceNumber;
    private Double totalAmount;
    

}
