package com.business.RJB.model;

import jakarta.persistence.*;

@Entity
@Table(name = "PRODUCTS")
public class Products {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "product_code")
    private String productCode;
    @Column(name = "name")
    private String name;
    @Column(name = "qualtity")
    private Long qualtity;
    @Column(name = "price")
    private Long price;
    @Column(name = "alert_enabled")
    private Boolean alertEnabled;
}
