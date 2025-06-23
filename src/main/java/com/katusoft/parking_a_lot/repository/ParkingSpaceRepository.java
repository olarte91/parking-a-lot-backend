package com.katusoft.parking_a_lot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.katusoft.parking_a_lot.model.ParkingSpace;
import com.katusoft.parking_a_lot.utils.ParkingSpotStatus;

public interface ParkingSpaceRepository extends JpaRepository<ParkingSpace, Long>{
    public List<ParkingSpace> findByStatus(ParkingSpotStatus status);
}
