package com.katusoft.parking_a_lot.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.katusoft.parking_a_lot.dto.RegisterRequestDTO;
import com.katusoft.parking_a_lot.model.Register;
import com.katusoft.parking_a_lot.service.RegisterService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/register")
@RequiredArgsConstructor
public class RegisterController {

    private final RegisterService registerService;

    @PostMapping
    public ResponseEntity<Register> registerVehicle(@RequestBody RegisterRequestDTO registerRequest){
        Register savedRegister = registerService.registerEntry(registerRequest);

        return ResponseEntity.status(HttpStatus.CREATED).body(savedRegister);
    }

}
