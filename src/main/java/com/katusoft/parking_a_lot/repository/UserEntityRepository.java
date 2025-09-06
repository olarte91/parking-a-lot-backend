package com.katusoft.parking_a_lot.repository;


import com.katusoft.parking_a_lot.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserEntityRepository extends JpaRepository<UserEntity, UUID>{

  Optional<UserEntity> findUserEntityByUsername(String username);
  boolean existsUserEntityByUsername(String username);
  boolean existsUserEntityByEmail(String email);
}
