package com.se.desafiobackendse.payment;

import java.math.BigDecimal;


public interface Payment {

    String generatePaymentLink(BigDecimal value);
}
