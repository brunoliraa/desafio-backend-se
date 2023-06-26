package com.se.desafiobackendse.payment;

import java.math.BigDecimal;

public record PaymentRequest(
        BigDecimal totalAmount,
        BigDecimal value,

        BigDecimal increase,

        BigDecimal discount,

        Double increasePercent,

        Double discountPercent

) {
}
