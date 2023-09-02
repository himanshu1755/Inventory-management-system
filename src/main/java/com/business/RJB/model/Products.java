package com.business.RJB.model;

import com.google.gson.annotations.SerializedName;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "PRODUCTS")
public class Products {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "product_code")
    private String productCode;
    @Column(name = "name")
    private String name;
    @Column(name = "type")
    private String type;
    @Column(name = "quantity")
    private Long quantity;
    @Column(name = "price")
    private Long price;
    @SerializedName(value = "alert_enabled")
    @Column(name = "alert_enabled")
    private String alertEnabled;
}
