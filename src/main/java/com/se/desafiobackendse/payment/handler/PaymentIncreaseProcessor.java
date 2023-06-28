package com.se.desafiobackendse.payment.handler;

import com.se.desafiobackendse.payment.PaymentRequest;

public class PaymentIncreaseProcessor extends PaymentProcessor {
    @Override
    protected void handle(PaymentRequest paymentRequest) {
        paymentRequest.setTotalAmount(paymentRequest.getTotalAmount().add(paymentRequest.getIncrease()));
    }
}
