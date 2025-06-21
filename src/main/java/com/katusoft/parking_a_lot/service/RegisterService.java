package com.katusoft.parking_a_lot.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.katusoft.parking_a_lot.dto.RegisterRequestDTO;
import com.katusoft.parking_a_lot.model.ParkingSpace;
import com.katusoft.parking_a_lot.model.Register;
import com.katusoft.parking_a_lot.model.Vehicle;
import com.katusoft.parking_a_lot.repository.ParkingSpaceRepository;
import com.katusoft.parking_a_lot.repository.RegisterRepository;
import com.katusoft.parking_a_lot.repository.VehicleRepository;
import com.katusoft.parking_a_lot.utils.ParkingSpotStatus;
import com.katusoft.parking_a_lot.utils.ParkingType;
import com.katusoft.parking_a_lot.utils.RegisterStatus;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RegisterService {

    private final RegisterRepository registerRepository;
    private final VehicleRepository vehicleRepository;
    private final ParkingSpaceRepository parkingSpaceRepository;

    public List<Register> getAll() {
        List<Register> registerList = registerRepository.findAll();
        return registerList;
    }

    public Register registerEntry(RegisterRequestDTO registerRequest) {
        Register newRegister = new Register();

        if (vehicleRepository.existsByLicensePlate(registerRequest.getLicensePlate())) {
            Vehicle vehicle = vehicleRepository.findByLicensePlate(registerRequest.getLicensePlate());
            newRegister.setVehicle(vehicle);
        } else {
            Vehicle vehicle = new Vehicle();
            vehicle.setLicensePlate(registerRequest.getLicensePlate());
            vehicleRepository.save(vehicle);
            newRegister.setVehicle(vehicle);
        }

        if (parkingSpaceRepository.existsById(registerRequest.getParkingSpaceNumber())) {

            ParkingSpace parkingSpace = parkingSpaceRepository
                    .findById(registerRequest.getParkingSpaceNumber())
                    .orElseThrow(() -> new RuntimeException("Parking space not found"));
            newRegister.setParkingSpace(parkingSpace);
        } else {

            ParkingSpace parkingSpace = new ParkingSpace();
            parkingSpace.setStatus(ParkingSpotStatus.OCCUPIED);
            parkingSpace.setType(ParkingType.MOTO);
            parkingSpaceRepository.save(parkingSpace);
            newRegister.setParkingSpace(parkingSpace);
        }

        newRegister.setDateTimeEntrance(registerRequest.getDateTime());
        newRegister.setStatus(RegisterStatus.ACTIVE);
        registerRepository.save(newRegister);
        return newRegister;
    }
}
