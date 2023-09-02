package com.business.RJB.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "USERS")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;
    @Column(name = "password")
    private String password;
    @Column(name = "type")
    private String type;
}
