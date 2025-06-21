package com.katusoft.parking_a_lot.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.katusoft.parking_a_lot.model.ParkingSpace;
import com.katusoft.parking_a_lot.repository.ParkingSpaceRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ParkingSpaceService {

    private final ParkingSpaceRepository parkingSpaceRepository;

    public List<ParkingSpace> getAll(){
        List<ParkingSpace> parkingSpaces = parkingSpaceRepository.findAll();

        return parkingSpaces;
    }
}
