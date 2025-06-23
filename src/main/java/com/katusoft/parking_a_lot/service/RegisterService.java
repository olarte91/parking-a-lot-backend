package com.katusoft.parking_a_lot.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.katusoft.parking_a_lot.dto.RegisterRequestDTO;
import com.katusoft.parking_a_lot.dto.RegisterResponseDTO;
import com.katusoft.parking_a_lot.model.ParkingSpace;
import com.katusoft.parking_a_lot.model.Register;
import com.katusoft.parking_a_lot.model.Vehicle;
import com.katusoft.parking_a_lot.repository.ParkingSpaceRepository;
import com.katusoft.parking_a_lot.repository.RegisterRepository;
import com.katusoft.parking_a_lot.repository.VehTypeRepository;
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
    private final VehTypeRepository vehTypeRepository;

    /**
     * Para devolver todos los elementos de la tabla register,
     * debemos crear un DTO en este caso RegisterResponseDTO que devuelve 
     * sólo los datos que necesitamos que nuestro cliente vea.
     */
    public List<RegisterResponseDTO> getAll() {
        //Primero creamos una lista de registros que nos devuelve los datos completos de los registros
        List<Register> registers = registerRepository.findAll();
        return registers.stream() //Utilizamos stream para hacerle un mapeo a cada registro y mostrar solo lo necesario
        .map(register -> {
            RegisterResponseDTO dto = new RegisterResponseDTO();
            dto.setId(register.getId());
            dto.setLicensePlate(register.getVehicle().getLicensePlate());
            dto.setVehicleType(register.getVehicle().getVehType().getType());
            dto.setDateTimeEntrance(register.getDateTimeEntrance());
            dto.setDateTimeDeparture(register.getDateTimeDeparture());
            dto.setParkingSpaceNumber(register.getParkingSpace().getId());
            dto.setTotalAmount(register.getAmount());
            return dto;
        }).collect(Collectors.toList());
    }

    public Register registerEntry(RegisterRequestDTO registerRequest) {
        Register newRegister = new Register();

        if (vehicleRepository.existsByLicensePlate(registerRequest.getLicensePlate())) {
            Vehicle vehicle = vehicleRepository.findByLicensePlate(registerRequest.getLicensePlate());
            newRegister.setVehicle(vehicle);
        } else {
            Vehicle vehicle = new Vehicle();
            vehicle.setVehType(vehTypeRepository.findById(registerRequest.getVehicleType())
            .orElseThrow(() -> new RuntimeException("Vehicle type not found")));
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

        newRegister.setDateTimeEntrance(registerRequest.getDateTimeEntrance());
        newRegister.setStatus(RegisterStatus.ACTIVE);
        registerRepository.save(newRegister);
        return newRegister;
    }
}
