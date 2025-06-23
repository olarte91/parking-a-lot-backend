package com.katusoft.parking_a_lot.controller;

import com.katusoft.parking_a_lot.model.ParkingSpace;
import com.katusoft.parking_a_lot.service.ParkingSpaceService;
import com.katusoft.parking_a_lot.utils.ParkingSpotStatus;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/parking-space")
public class ParkingSpaceController {

    private final ParkingSpaceService parkingSpaceService;

    ParkingSpaceController(ParkingSpaceService parkingSpaceService) {
        this.parkingSpaceService = parkingSpaceService;
    }

    @GetMapping()
    public String test(){
        return "Test endpoint parking-space";
    }

    @GetMapping("available-spaces")
    public List<ParkingSpace> getByStatus(@RequestParam ParkingSpotStatus param) {
        return parkingSpaceService.getByStatus(param);
    }
    

}
