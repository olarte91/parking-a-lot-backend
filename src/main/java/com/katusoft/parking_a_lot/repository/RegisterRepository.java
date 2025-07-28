package com.katusoft.parking_a_lot.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.katusoft.parking_a_lot.model.Register;
import com.katusoft.parking_a_lot.enums.RegisterStatus;

public interface RegisterRepository extends JpaRepository<Register, Long>{

    public Register findByVehicleLicensePlate(String licensePlate);
    
    public Register findByStatusAndVehicleLicensePlate(RegisterStatus status, String licensePlate);
}
