package com.se.desafiobackendse.payment;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@WebMvcTest(PaymentController.class)
public class PaymentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PaymentService paymentService;


    @Test
    public void shouldReturnPaymentLinkWhenSuccess() throws Exception {

        var mockResponse = new PaymentResponse("http://payment-link.com");

        Mockito.when(paymentService.getPaymentLink(any())).thenReturn(mockResponse);

        mockMvc.perform(get("/payment?totalAmount=50.00&value=8.00&increase=8.00&discount=20.00")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.paymentLink").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.paymentLink").value("http://payment-link.com"));
    }

    @Test
    public void shouldRedirectToPaymentLinkWhenSuccess() throws Exception {

        var mockResponse = new PaymentResponse("http://payment-link.com");

        Mockito.when(paymentService.getPaymentLink(any())).thenReturn(mockResponse);

        mockMvc.perform(get("/payment/redirect?totalAmount=50.00&value=8.00&increase=8.00&discount=20.00")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isSeeOther());
    }

}
