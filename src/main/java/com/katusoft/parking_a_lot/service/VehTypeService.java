package com.katusoft.parking_a_lot.service;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.katusoft.parking_a_lot.model.VehType;
import com.katusoft.parking_a_lot.repository.VehTypeRepository;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class VehTypeService {

    private final VehTypeRepository vehTypeRepository;

    public List<VehType> getAll(){
        List<VehType> vehTypeList = vehTypeRepository.findAll();
        return vehTypeList;
    }

}
