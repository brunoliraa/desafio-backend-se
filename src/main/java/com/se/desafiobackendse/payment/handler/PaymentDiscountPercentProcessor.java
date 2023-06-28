package com.se.desafiobackendse.payment.handler;

import com.se.desafiobackendse.payment.PaymentRequest;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class PaymentDiscountPercentProcessor extends PaymentProcessor {

    @Override
    protected void handle(PaymentRequest paymentRequest) {

        if(paymentRequest.getDiscountPercent() != null) {
            final var total = paymentRequest.getValueToPay()
                    .subtract(paymentRequest.getValueToPay()
                    .multiply(new BigDecimal(paymentRequest.getDiscountPercent() / 100)))
                    .setScale(2, RoundingMode.HALF_EVEN);

            paymentRequest.setValueToPay(total);
        }
    }
}
