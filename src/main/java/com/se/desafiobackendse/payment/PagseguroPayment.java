package com.se.desafiobackendse.payment;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;


@Service
public class PagseguroPayment implements Payment {
    @Override
    public String generatePaymentLink(BigDecimal value) {
        return "https://sandbox.pagseguro.uol.com.br/checkout/nc/sender-data-payment-methods.jhtml?t=45b1b01482df38a4925e076cac14bf98";
    }
}
