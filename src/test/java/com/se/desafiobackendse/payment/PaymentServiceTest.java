package com.se.desafiobackendse.payment;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(SpringExtension.class)
public class PaymentServiceTest {

    @Mock
    private PagseguroClient client;

    @Mock
    private Payment payment;

    @InjectMocks
    private PaymentService paymentService;

    @Test
    public void shouldReturnPaymentLinkWhenSuccess() {

        var value = new BigDecimal(10);

        var paymentRequest = new PaymentRequest(value, value, value, value, value, null, null);

        var checkoutMock  = new Checkout("code");

        BDDMockito.when(client.createCheckout(any())).thenReturn(checkoutMock);
        BDDMockito.when(payment.generatePaymentLink(any())).thenReturn("http://payment-link.com");

        var result = paymentService.getPaymentLink(paymentRequest);
        assertThat(result.paymentLink()).isNotNull();
        assertThat(result.paymentLink()).isEqualTo("http://payment-link.com");
    }
}
