package com.group.express.controller;

import com.group.express.domain.BusBooking;
import com.group.express.repository.BusBookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.group.express.service.BusBookingService;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/busTicket")
public class BusBookingController {

    private final BusBookingService BusBookingService;
    private final BusBookingRepository BusBookingRepository;

    @Autowired
    private BusBookingController(BusBookingService BusBookingService, BusBookingRepository BusBookingRepository){
        this.BusBookingService=BusBookingService;
        this.BusBookingRepository = BusBookingRepository;
    }

    @GetMapping("/BusBooking/{id}")
    public ResponseEntity<List<BusBooking>> getBusBooking(@PathVariable String id) {
        return ResponseEntity.ok(BusBookingService.getBusBookingList(id));}

    @PostMapping("/Success")
    public ResponseEntity<String> handletrainTicketSuccess (@RequestBody BusBooking busBooking) {
        try {
            BusBookingService.busTicketSuccess(busBooking);
            return ResponseEntity.ok("busTicket DB Save success");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("busTicket DB Save failed");
        }
    }

}
