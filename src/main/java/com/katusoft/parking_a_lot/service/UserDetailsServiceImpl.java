package com.katusoft.parking_a_lot.service;

import com.katusoft.parking_a_lot.model.UserEntity;
import com.katusoft.parking_a_lot.repository.UserEntityRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

  UserEntityRepository userEntityRepository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

    UserEntity user = userEntityRepository.findUserEntityByUsername(username)
        .orElseThrow(() -> new UsernameNotFoundException(username));

    List<SimpleGrantedAuthority> authorityList = new ArrayList<>();

    user.getRoles()
        .forEach(role -> authorityList.add(new SimpleGrantedAuthority("ROLE_".concat(role.getRoleEnum().name()))));

    user.getRoles().stream()
        .flatMap(role -> role.getPermissionsList().stream())
        .forEach(permission -> authorityList.add(new SimpleGrantedAuthority(permission.getName())));

    return new User(
        user.getUsername(),
        user.getPassword(),
        user.isEnabled(),
        user.isAccountNoExpired(),
        user.isCredentialNoExpired(),
        user.isAccountNoLocked(),
        authorityList
    );

  }
}
