package com.example.travelapp.controller;

import com.example.travelapp.model.Order;
import com.example.travelapp.service.PaypalService;
import com.paypal.api.payments.Links;
import com.paypal.api.payments.Payment;
import com.paypal.base.rest.PayPalRESTException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLOutput;

@RestController
@CrossOrigin
public class PaypalController {
    @Autowired
    PaypalService service;
    public static final String SUCCESS_URL="pay/success";
    public static final String CANCEL_URL="pay/cancel";
    @GetMapping("")
    public String home(){
        return "home";
    }
    @PostMapping("/pay")
    public String payment(@RequestBody Order order){
        try {
            Payment payment= service.createPayment(order.getPrice(),order.getCurrency(),
                    order.getMethod(),order.getIntent(),order.getDescription(),"http://localhost:8080/"+CANCEL_URL
                    ,"http://localhost:8080/"+SUCCESS_URL);

            for(Links link:payment.getLinks()) {
                if(link.getRel().equals("approval_url")) {
                    return link.getHref();
                }
            }
        }catch (PayPalRESTException e){
            e.printStackTrace();
        }
        return "redirect:/";


    }
    @GetMapping(value = CANCEL_URL)
    public String cancelPay(){
        return "cancel";
    }
    @GetMapping(value = SUCCESS_URL)
    public String successPay(@RequestParam("paymentId") String paymentID,@RequestParam("PayerID") String payerID){
        try {
            Payment payment = service.executePayment(paymentID, payerID);

            if (payment.getState().equals("approved")) {
                return payment.toJSON();
            }
            else {
                return "thanh toan khong thanh cong";
            }
        } catch (PayPalRESTException e) {
            System.out.println(e.getMessage());
        }
        return "redirect:/";

    }
}
