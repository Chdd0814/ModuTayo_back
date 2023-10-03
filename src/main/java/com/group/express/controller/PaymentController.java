package com.group.express.controller;

import com.group.express.domain.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.group.express.service.PaymentService;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class PaymentController {

    private final PaymentService PaymentService;

    @Autowired
    private PaymentController(PaymentService PaymentService){this.PaymentService=PaymentService;}

    @GetMapping("/Payment/{id}")
    public ResponseEntity<List<Payment>> getBusBooking(@PathVariable String id) {
        return ResponseEntity.ok(PaymentService.getPaymentList(id));}

}
