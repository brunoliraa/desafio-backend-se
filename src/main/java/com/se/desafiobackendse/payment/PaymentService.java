package com.se.desafiobackendse.payment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    @Autowired
    private Payment payment;

    @Autowired
    private PagseguroClient client;

    public PaymentResponse getPaymentLink(final PaymentRequest paymentRequest) {
        return new PaymentResponse(payment.generatePaymentLink(paymentRequest.value()));
    }
}
