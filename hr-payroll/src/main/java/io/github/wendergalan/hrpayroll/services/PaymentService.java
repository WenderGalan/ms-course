package io.github.wendergalan.hrpayroll.services;

import io.github.wendergalan.hrpayroll.entities.Payment;
import io.github.wendergalan.hrpayroll.entities.Worker;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class PaymentService {
    private final RestTemplate restTemplate;

    @Value("${hr-worker.host}")
    private String workerHost;

    public Payment getPayment(long workerId, int days) {
        Map<String, String> uriVariables = new HashMap<>();
        uriVariables.put("id", String.valueOf(workerId));

        Worker worker = restTemplate.getForObject(workerHost + "/workers/{id}", Worker.class, uriVariables);

        return Payment.builder()
                .name(worker.getName())
                .dailyIncome(worker.getDailyIncome())
                .days(days)
                .build();
    }
}
