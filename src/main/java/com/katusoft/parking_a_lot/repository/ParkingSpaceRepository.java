package com.katusoft.parking_a_lot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.katusoft.parking_a_lot.model.ParkingSpace;

public interface ParkingSpaceRepository extends JpaRepository<ParkingSpace, Long>{

}
