package com.training.spring.eureaka.provider.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment-provider")
public class PaymentController {
    @GetMapping("/paynow/{price}")
    public String payNow(@PathVariable int price){
        System.out.println("Price is " + price);
        return "payment with" + price + "is successfull";
    }
}
