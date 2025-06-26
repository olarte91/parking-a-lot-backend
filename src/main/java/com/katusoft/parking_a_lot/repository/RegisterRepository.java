package com.katusoft.parking_a_lot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.katusoft.parking_a_lot.model.Register;
import com.katusoft.parking_a_lot.utils.RegisterStatus;

public interface RegisterRepository extends JpaRepository<Register, Long>{

    public Register findByVehicleLicensePlate(String licensePlate);
    
    public Register findByVehicleLicensePlateAndStatus(String licensePlate, RegisterStatus status);
}
