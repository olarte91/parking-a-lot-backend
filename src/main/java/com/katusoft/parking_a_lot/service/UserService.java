package com.katusoft.parking_a_lot.service;

import com.katusoft.parking_a_lot.dto.CreateUserRequestDto;
import com.katusoft.parking_a_lot.dto.UserReponseDto;
import com.katusoft.parking_a_lot.model.UserEntity;
import com.katusoft.parking_a_lot.repository.UserEntityRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UserService {

  UserEntityRepository userEntityRepository;

  private PasswordEncoder passwordEncoder;

//  public UserReponseDto createUser(CreateUserRequestDto request) {
//    if(userEntityRepository.existsUserEntityByUsername(request.getUsername())) {
//      throw new RuntimeException("El usuario ya existe");
//    }
//
//    if(userEntityRepository.existsUserEntityByEmail(request.getEmail())) {
//      throw new RuntimeException("El email ya está registrado");
//    }
//
//    UserEntity userEntity = UserEntity.builder()
//        .userName(request.getUsername())
//        .password(passwordEncoder.encode(request.getPassword()))
//        .email(request.getEmail())
//        .createdAt(LocalDateTime.now())
//        .build();
//  }
//
}
