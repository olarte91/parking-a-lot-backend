package com.katusoft.parking_a_lot.model;

import java.util.List;

import com.katusoft.parking_a_lot.enums.Role;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "app_user")
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private Role role;

    @Column(name = "password")
    private String password;

    @OneToMany(mappedBy = "userEntrance", cascade = CascadeType.ALL)
    private List<Register> registerEntrances;

    @OneToMany(mappedBy = "userDeparture", cascade = CascadeType.ALL)
    private List<Register> registerDeparture;

}
