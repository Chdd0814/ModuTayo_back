package com.group.express.controller;

import com.group.express.domain.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.group.express.service.PaymentService;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/payment")
public class PaymentController {

    private final PaymentService PaymentService;

    @Autowired
    private PaymentController(PaymentService PaymentService){this.PaymentService=PaymentService;}

    @GetMapping("/Payment/{id}")
    public ResponseEntity<List<Payment>> getBusBooking(@PathVariable String id) {
        return ResponseEntity.ok(PaymentService.getPaymentList(id));}

    @PostMapping("/getPaymentinfo")
    public ResponseEntity<String> handlePaymentSuccess(@RequestBody Payment payment) {
        try {
            PaymentService.PaymentSuccess(payment);
            return ResponseEntity.ok("Payment success");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Payment failed");
        }
    }
    }




