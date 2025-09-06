package com.katusoft.parking_a_lot.controller;

import java.util.List;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.katusoft.parking_a_lot.dto.RegisterRequestDTO;
import com.katusoft.parking_a_lot.dto.RegisterResponseDTO;
import com.katusoft.parking_a_lot.model.Register;
import com.katusoft.parking_a_lot.repository.RegisterRepository;
import com.katusoft.parking_a_lot.service.RegisterService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/register")
@RequiredArgsConstructor
@PreAuthorize("denyAll()")
public class RegisterController {
    
    private static final Logger logger = LogManager.getLogger(RegisterController.class);

    private final RegisterService registerService;
    private final RegisterRepository registerRepository;

    @GetMapping()
    @PreAuthorize("hasAnyAuthority('READ')")
    public ResponseEntity<List<RegisterResponseDTO>> getAll() {
        logger.info("Obteniendo Usuarios");
        List<RegisterResponseDTO> registerResponseDTO = registerService.getAll();
        
        return ResponseEntity.ok(registerResponseDTO);
    }
    

    @PostMapping("entrance")
    public ResponseEntity<Register> registerVehicle(@RequestBody RegisterRequestDTO registerRequest){
        Register savedRegister = registerService.registerEntry(registerRequest);
        logger.info("Ingresa vehículo con placa: {} - tipo {}", registerRequest.getLicensePlate(), registerRequest.getVehicleType());

        return ResponseEntity.status(HttpStatus.CREATED).body(savedRegister);
    }

    @PostMapping("departure")
    public ResponseEntity<Register> registerVehicleDeparture(@RequestBody String licensePlate){
        Register savedRegister = registerService.registerExit(licensePlate);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(savedRegister);
    }

}
