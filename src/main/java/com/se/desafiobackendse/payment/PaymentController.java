package com.se.desafiobackendse.payment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.net.URISyntaxException;


@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PaymentResponse> getPaymentLink(PaymentRequest paymentRequest) {
        return ResponseEntity.ok(paymentService.getPaymentLink(paymentRequest));
    }

    @GetMapping("/redirect")
    public ResponseEntity<?> redirect(PaymentRequest paymentRequest) throws URISyntaxException {

        URI redirect = new URI(paymentService.getPaymentLink(paymentRequest).paymentLink());
        return ResponseEntity.status(HttpStatus.SEE_OTHER)
                .location(redirect).build();
    }

}
