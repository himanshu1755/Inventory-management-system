package com.business.RJB.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "PURCHASE")
public class Purchase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "product_sold_id")
    private String productSoldId;
    @Column(name = "namproduct_sold_name")
    private String productSoldName;
    @Column(name = "year")
    private Long year;
    @Column(name = "sold_date")
    private Date soldDate;
    @Column(name = "quantity")
    private Long quantity;
}
