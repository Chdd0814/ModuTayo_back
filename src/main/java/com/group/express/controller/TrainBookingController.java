package com.group.express.controller;

import com.group.express.domain.Seats;
import com.group.express.domain.TrainBooking;
import com.group.express.repository.TrainBookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.group.express.service.TrainBookingService;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/trainTicket")
public class TrainBookingController {

    private final TrainBookingService TrainBookingService;
    private final TrainBookingRepository TrainBookingRepository;

    @Autowired
    TrainBookingController(TrainBookingService TrainBookingService, TrainBookingRepository TrainBookingRepository){
        this.TrainBookingService=TrainBookingService;
        this.TrainBookingRepository = TrainBookingRepository;
    }

    @GetMapping("/TrainBooking/{id}")
    public ResponseEntity<List<TrainBooking>> getTrainBooking(@PathVariable String id) {
        return ResponseEntity.ok(TrainBookingService.getTrainBookingList(id));}

    @PostMapping("/Success")
    public ResponseEntity<String> handletrainTicketSuccess (@RequestBody TrainBooking trainBooking) {
        try {
            TrainBookingService.trainTicketSuccess(trainBooking);
            return ResponseEntity.ok("trainTicket DB Save success");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("trainTIcket DB Save failed");
        }
    }

//    @GetMapping("/findSeat")
//    public ResponseEntity<List<TrainBooking>> findSeat (@ModelAttribute Seats seat)
//    {return ResponseEntity.ok(TrainBookingRepository.findBySeat(seat));}
}
