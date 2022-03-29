package com.prajeev.demo.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="user")
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="username", unique = true)
    private String username;

    @Column(name="password", nullable = false)
    private String password;

    @Column(name="roles", nullable = false)
    private String roles;
}
