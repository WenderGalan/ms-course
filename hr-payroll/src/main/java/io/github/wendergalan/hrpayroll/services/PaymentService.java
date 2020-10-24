package io.github.wendergalan.hrpayroll.services;

import io.github.wendergalan.hrpayroll.entities.Payment;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    public Payment getPayment(long workerId, int days) {
        return Payment.builder()
                .name("Bob")
                .dailyIncome(200.0)
                .days(days)
                .build();
    }
}
