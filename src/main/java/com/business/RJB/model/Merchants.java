package com.business.RJB.model;


import jakarta.persistence.*;

@Entity
@Table(name = "MERCHANTS")
public class Merchants {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "location")
    private String location;
}
