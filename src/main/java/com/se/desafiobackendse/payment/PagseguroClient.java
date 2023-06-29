package com.se.desafiobackendse.payment;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;

@Component
public class PagseguroClient {

    private RestTemplate restTemplate = new RestTemplate();
    private String email = "bruno_2010.1@hotmail.com";
    private String token = "0908581DE02D4354B06AD1E33C0C186C";
    private String url = "https://ws.sandbox.pagseguro.uol.com.br/v2/checkout";


    public Checkout createCheckout(final BigDecimal value) {
        try {
            final HttpHeaders headers = new HttpHeaders();

            headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

            final HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(buildFormParamsRequest(value), headers);

            final ResponseEntity<String> response = restTemplate.postForEntity(
                    "https://ws.sandbox.pagseguro.uol.com.br/v2/checkout?email=" + email + "&token=" + token
                    , request, String.class);

            final XmlMapper mapper = new XmlMapper();

            final var checkout = mapper.readValue(response.getBody(), Checkout.class);

            return checkout;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private MultiValueMap<String, String> buildFormParamsRequest(final BigDecimal value) {

        final MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("currency", "BRL");
        map.add("itemId1", "food");
        map.add("itemDescription1", "delivery food");
        map.add("itemAmount1", value.toString());
        map.add("itemQuantity1", "1");
        map.add("senderName", "nome sobrenome");
        map.add("senderAreaCode", "11");
        map.add("senderEmail", "any@email.com");
        map.add("shippingAddressRequired", "false");
        map.add("extraAmount", "0.00");

        return map;
    }

}
