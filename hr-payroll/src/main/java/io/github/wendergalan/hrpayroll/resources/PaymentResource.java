package io.github.wendergalan.hrpayroll.resources;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import io.github.wendergalan.hrpayroll.entities.Payment;
import io.github.wendergalan.hrpayroll.services.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/payments")
@RequiredArgsConstructor
public class PaymentResource {
    private final PaymentService service;

    @HystrixCommand(fallbackMethod = "getPaymentAlternative")
    @GetMapping(value = "/{workerId}/days/{days}")
    public ResponseEntity<Payment> getPayment(@PathVariable Long workerId,
                                              @PathVariable Integer days) {
        return ResponseEntity.ok(service.getPayment(workerId, days));
    }

    public ResponseEntity<Payment> getPaymentAlternative(Long workerId, Integer days) {
        // Aqui você pode fazer alguma implementação diferente da original
        return ResponseEntity.badRequest().build();
    }
}
