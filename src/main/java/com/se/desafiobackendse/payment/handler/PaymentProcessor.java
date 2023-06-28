package com.se.desafiobackendse.payment.handler;

import com.se.desafiobackendse.payment.PaymentRequest;

public abstract class PaymentProcessor {

    private PaymentProcessor next;

    public void setNext(PaymentProcessor paymentHandler) {
        if(next == null) {
            next = paymentHandler;
        }
        else {
            next.setNext(paymentHandler);
        }
    }

    public PaymentRequest process(PaymentRequest paymentRequest) {
        handle(paymentRequest);
        if(next != null) {
            return next.process(paymentRequest);
        }
        else {
            return paymentRequest;
        }
    }

    protected abstract void handle(PaymentRequest paymentRequest);

}







