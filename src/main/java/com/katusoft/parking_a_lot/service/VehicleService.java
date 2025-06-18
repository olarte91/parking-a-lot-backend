package com.katusoft.parking_a_lot.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.katusoft.parking_a_lot.model.Vehicle;
import com.katusoft.parking_a_lot.repository.VehicleRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class VehicleService {

    private final VehicleRepository vehicleRepository;

    public List<Vehicle> getAll(){
        List<Vehicle> vehicleList = vehicleRepository.findAll();
        return vehicleList;
    }
}
