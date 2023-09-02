package com.business.RJB.model;

import com.google.gson.annotations.SerializedName;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name = "PAYMENT")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @SerializedName(value = "merchant_id")
    @Column(name = "merchant_id")
    private Long merchantId;

    @SerializedName(value = "merchant_name")
    @Column(name = "merchant_name")
    private String merchantName;
    @Column(name = "date")
    private Date date;

    @SerializedName(value = "total_amount")
    @Column(name = "total_amount")
    private Long totalAmount;

    @SerializedName(value = "amount_paid")
    @Column(name = "amount_paid")
    private Long anountPaid;

    @SerializedName(value = "amount_unpaid")
    @Column(name = "amount_unpaid")
    private Long anountUnpaid;

    @SerializedName(value = "bill_no")
    @Column(name = "bill_no")
    private String billNo;

    @SerializedName(value = "payment_method")
    @Column(name = "payment_method")
    private String paymentMethod;
}
