package com.katusoft.parking_a_lot.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.katusoft.parking_a_lot.model.AppUser;
import com.katusoft.parking_a_lot.repository.AppUserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AppUserService {

    private final AppUserRepository appUserRepository;

    public List<AppUser> getAll(){
        List<AppUser> usersList = appUserRepository.findAll();
        return usersList;
    }

}
