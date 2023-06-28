package com.se.desafiobackendse.payment;

import java.math.BigDecimal;

public class PaymentRequest {

    private BigDecimal totalAmount;
    private BigDecimal value;

    private BigDecimal valueToPay;

    private BigDecimal increase;

    private BigDecimal discount;

    private Double increasePercent;

    private Double discountPercent;

    public PaymentRequest(BigDecimal totalAmount, BigDecimal value, BigDecimal valueToPay, BigDecimal increase, BigDecimal discount, Double increasePercent, Double discountPercent) {
        this.totalAmount = totalAmount;
        this.value = value;
        this.valueToPay = valueToPay;
        this.increase = increase;
        this.discount = discount;
        this.increasePercent = increasePercent;
        this.discountPercent = discountPercent;
    }

    @Deprecated
    protected PaymentRequest() {
    }


    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public BigDecimal getValueToPay() {
        return valueToPay;
    }

    public void setValueToPay(BigDecimal valueToPay) {
        this.valueToPay = valueToPay;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public BigDecimal getIncrease() {
        return increase;
    }

    public void setIncrease(BigDecimal increase) {
        this.increase = increase;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public Double getIncreasePercent() {
        return increasePercent;
    }

    public void setIncreasePercent(Double increasePercent) {
        this.increasePercent = increasePercent;
    }

    public Double getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(Double discountPercent) {
        this.discountPercent = discountPercent;
    }

}
