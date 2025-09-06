package com.katusoft.parking_a_lot.dto;

import com.katusoft.parking_a_lot.enums.Role;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Builder
public class UserReponseDto {

  private UUID id;
  private String username;
  private String email;
  private LocalDateTime createdAt;
}
