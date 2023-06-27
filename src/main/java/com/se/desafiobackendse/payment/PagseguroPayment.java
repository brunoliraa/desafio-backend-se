package com.se.desafiobackendse.payment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;


@Service
public class PagseguroPayment implements Payment {

    private final String pagseguroUrl = "https://sandbox.pagseguro.uol.com.br/v2/checkout/payment.html";

    @Autowired
    private PagseguroClient pagseguroClient;


    @Override
    public String generatePaymentLink(final BigDecimal value) {
        final var checkout = pagseguroClient.createCheckout(value);
        return buildPaymentLink(checkout);
    }

    private String buildPaymentLink(final Checkout checkout) {
        return pagseguroUrl+ "?code="+ checkout.code();
    }
}
