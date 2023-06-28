package com.se.desafiobackendse.payment.handler;

import com.se.desafiobackendse.payment.PaymentRequest;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class PaymentIncreasePercentProcessor extends PaymentProcessor {
    @Override
    protected void handle(PaymentRequest paymentRequest) {

        if (paymentRequest.getIncreasePercent() != null) {
            final var total = paymentRequest.getValueToPay()
                    .add(paymentRequest.getValueToPay()
                    .multiply(new BigDecimal(paymentRequest.getIncreasePercent() / 100)))
                    .setScale(2, RoundingMode.HALF_EVEN);

            paymentRequest.setValueToPay(total);
        }

    }
}
