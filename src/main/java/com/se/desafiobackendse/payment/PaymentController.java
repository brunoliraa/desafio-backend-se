package com.se.desafiobackendse.payment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @GetMapping
    public ResponseEntity<PaymentResponse> getPaymentLink(PaymentRequest paymentRequest) {

        return ResponseEntity.ok(paymentService.getPaymentLink(paymentRequest));
    }

}
