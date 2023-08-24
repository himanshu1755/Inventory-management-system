package com.business.RJB.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "PAYMENT_HISTORY")
public class PaymentHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "merchant_id")
    private Long merchantId;
    @Column(name = "merchant_name")
    private String merchantName;
    @Column(name = "date")
    private Date date;
    @Column(name = "amount_paid")
    private Long anountPaid;
    @Column(name = "amount_unpaid")
    private Long anountUnpaid;
    @Column(name = "bill_no")
    private String billNo;
    @Column(name = "payment_method")
    private String paymentMethod;
}
