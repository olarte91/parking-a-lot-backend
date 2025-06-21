package com.katusoft.parking_a_lot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/parking-space")
public class ParkingSpaceController {

    @GetMapping()
    public String test(){
        return "Test endpoint parking-space";
    }

}
