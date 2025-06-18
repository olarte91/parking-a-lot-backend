package com.katusoft.parking_a_lot.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.katusoft.parking_a_lot.model.Register;
import com.katusoft.parking_a_lot.repository.RegisterRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RegisterService {

    private final RegisterRepository registerRepository;

    public List<Register> getAll(){
        List<Register> registerList = registerRepository.findAll();
        return registerList;
    }
}
