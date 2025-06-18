package com.katusoft.parking_a_lot.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.katusoft.parking_a_lot.model.Fare;
import com.katusoft.parking_a_lot.repository.FareRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FareService {

    private final FareRepository fareRepository;

    public List<Fare> getAll(){
        List<Fare> fareList = fareRepository.findAll();
        return fareList;
    }

}
