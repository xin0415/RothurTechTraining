package com.training.spring.eureka.client.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ShoppingController {

    @Autowired
    private RestTemplate template;

    @GetMapping("/amazon-payment/{price}")
    public String invokePaymentService(@PathVariable int price) {
        System.out.println("price is " + price);
        String url = "http://PAYMENT-SERVICE/payment-provider/paynow/" + price;     // url is case sensitive
        return template.getForObject(url, String.class);
    }
}
