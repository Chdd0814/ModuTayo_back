package com.group.express.controller;

import com.group.express.domain.TrainBooking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.group.express.service.TrainBookingService;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class TrainBookingController {

    private final TrainBookingService TrainBookingService;

    @Autowired
    TrainBookingController(TrainBookingService TrainBookingService){this.TrainBookingService=TrainBookingService;}

    @GetMapping("/TrainBooking/{id}")
    public ResponseEntity<List<TrainBooking>> getTrainBooking(@PathVariable String id) {
        return ResponseEntity.ok(TrainBookingService.getBusBookingList(id));}

}
