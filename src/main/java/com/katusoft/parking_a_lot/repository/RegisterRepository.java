package com.katusoft.parking_a_lot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.katusoft.parking_a_lot.model.Register;

public interface RegisterRepository extends JpaRepository<Register, Long>{

}
