package com.group.express.controller;

import com.group.express.domain.BusBooking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.group.express.service.BusBookingService;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class BusBookingController {

    private final BusBookingService BusBookingService;

    @Autowired
    private BusBookingController(BusBookingService BusBookingService){this.BusBookingService=BusBookingService;}

    @GetMapping("/BusBooking/{id}")
    public ResponseEntity<List<BusBooking>> getBusBooking(@PathVariable String id) {
        return ResponseEntity.ok(BusBookingService.getBusBookingList(id));}

}
