package com.business.RJB.service;

import com.business.RJB.model.Payment;
import com.business.RJB.repository.IPaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService {
    @Autowired
    private IPaymentRepository paymentRepository;

    public void savePayment(Payment payment){
        paymentRepository.save(payment);
    }

    public List<Payment> getAllPayments(){
        return paymentRepository.findAll();
    }
}
