package com.katusoft.parking_a_lot.service;

import java.util.List;

import com.katusoft.parking_a_lot.model.UserEntity;
import org.springframework.stereotype.Service;

import com.katusoft.parking_a_lot.repository.UserEntityRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserEntityService {

    private final UserEntityRepository appUserRepository;

    public List<UserEntity> getAll(){
        List<UserEntity> usersList = appUserRepository.findAll();
        return usersList;
    }

}
