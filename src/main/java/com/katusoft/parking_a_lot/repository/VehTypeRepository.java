package com.katusoft.parking_a_lot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.katusoft.parking_a_lot.model.VehType;

public interface VehTypeRepository extends JpaRepository<VehType, Long>{

}
