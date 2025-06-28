package com.katusoft.parking_a_lot.service;

import java.time.Duration;
import java.time.LocalDateTime;
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

        //Verificamos la existencia del vehículo por número de placa
        if (vehicleRepository.existsByLicensePlate(registerRequest.getLicensePlate())) {
            //Si el vehículo existe lo asignamos al nuevo registro esto con el fin de evitar duplicidades en la base de datos de vehículo
            Vehicle vehicle = vehicleRepository.findByLicensePlate(registerRequest.getLicensePlate());
            newRegister.setVehicle(vehicle);
        } else {
            //Creamos una nueva entrada de vehículo en caso de que no exista
            Vehicle vehicle = new Vehicle();
            vehicle.setVehType(vehTypeRepository.findById(registerRequest.getVehicleType())
            .orElseThrow(() -> new RuntimeException("Vehicle type not found")));
            vehicle.setLicensePlate(registerRequest.getLicensePlate());
            vehicleRepository.save(vehicle);
            newRegister.setVehicle(vehicle);
        }

        if(parkingSpaceRepository.existsById(registerRequest.getParkingSpaceNumber())){
            ParkingSpace parkingSpace = parkingSpaceRepository.findById(registerRequest.getParkingSpaceNumber())
                .orElseThrow(() -> new RuntimeException("Parking Space Not exists!"));
            
            newRegister.setParkingSpace(parkingSpace);
        }

        
        newRegister.setDateTimeEntrance(LocalDateTime.now());
        newRegister.setStatus(RegisterStatus.ACTIVE);
        registerRepository.save(newRegister);
        return newRegister;
    }

    public Register registerExit(String licensePlate){
        Register exitRegister = registerRepository.findByVehicleLicensePlateAndStatus(licensePlate,
                RegisterStatus.ACTIVE);

        if(exitRegister.getDateTimeDeparture() == null){
            exitRegister.setDateTimeDeparture(LocalDateTime.now());
        }

        

        //Calcular duración en horas
        Duration totalTime = Duration.between(exitRegister.getDateTimeEntrance(), exitRegister.getDateTimeDeparture());
        Long hours = totalTime.toHours();
        Integer minutesPart = totalTime.toMinutesPart();
        Double fare = exitRegister.getVehicle().getVehType().getFare().getValuePerHour();
        exitRegister.setAmount(calculateTotalValue(hours, minutesPart, fare));

        exitRegister.setStatus(RegisterStatus.INACTIVE);

        registerRepository.save(exitRegister);


        return exitRegister;

    }

    public Double calculateTotalValue(Long hours, Integer minutes, Double fare){
        Long totalHours = minutes >= 1 ? hours + 1 : hours;
        return fare * totalHours;
    }
}
