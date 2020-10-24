package io.github.wendergalan.hrpayroll.services;

import io.github.wendergalan.hrpayroll.entities.Payment;
import io.github.wendergalan.hrpayroll.entities.Worker;
import io.github.wendergalan.hrpayroll.feignclients.WorkerFeignClient;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentService {
    private final WorkerFeignClient workerFeignClient;

    public Payment getPayment(long workerId, int days) {
        ResponseEntity worker = workerFeignClient.findById(workerId);

        if (worker.getStatusCode() == HttpStatus.OK && worker.getBody() != null)
            return Payment.builder()
                    .name(((Worker) worker.getBody()).getName())
                    .dailyIncome(((Worker) worker.getBody()).getDailyIncome())
                    .days(days)
                    .build();
        return null;
    }
}
