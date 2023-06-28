package com.se.desafiobackendse.payment.handler;

import com.se.desafiobackendse.payment.PaymentRequest;

import java.math.RoundingMode;

public class PaymentValueToPayProcess extends PaymentProcessor{
    @Override
    protected void handle(PaymentRequest paymentRequest) {
        final var rate = paymentRequest.getValue().divide(paymentRequest.getTotalAmount(), 2, RoundingMode.HALF_EVEN);
        paymentRequest.setValueToPay(rate.multiply(paymentRequest.getValueToPay()).setScale(2, RoundingMode.HALF_EVEN));
    }
}
