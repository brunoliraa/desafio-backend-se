package com.se.desafiobackendse.payment;

import com.se.desafiobackendse.payment.handler.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    @Autowired
    private Payment payment;

    @Autowired
    private PagseguroClient client;

    public PaymentResponse getPaymentLink(final PaymentRequest paymentRequest) {

        var paymentProcessor = getPaymentProcessor();

        paymentProcessor.process(paymentRequest);

//        return new PaymentResponse(payment.generatePaymentLink(paymentRequest.value()));
        return new PaymentResponse(paymentRequest.getTotalAmount().toString());
    }

    private PaymentProcessor getPaymentProcessor() {
        PaymentProcessor processor = new PaymentIncreaseProcessor();
        processor.setNext(new PaymentIncreasePercentProcessor());
        processor.setNext(new PaymentDiscountProcessor());
        processor.setNext(new PaymentDiscountPercentProcessor());
        return processor;
    }
}
