package com.group.express.controller;

import com.group.express.domain.BusBooking;
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
import java.util.Optional;

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

    @GetMapping("/TrainBooking_admin")
    public ResponseEntity<List<TrainBooking>> getTrainBooking() {
        return ResponseEntity.ok(TrainBookingService.getTrainBookingList());}

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
    @GetMapping("/SearchFilter")
    public ResponseEntity<List<TrainBooking>> getListMember(@RequestParam String id, @RequestParam(required = false) String start, @RequestParam(required = false) String end
            , @RequestParam(required = false) String startDay, @RequestParam(required = false) String endDay){
        List<TrainBooking> TrainBooking=null;
        if(start.isEmpty()&&end.isEmpty()&&startDay.isEmpty()&&endDay.isEmpty()){
            TrainBooking = TrainBookingService.getTrainBookingList(id);

        }
        else if(!start.isEmpty()&&!end.isEmpty()&&!startDay.isEmpty()&&!endDay.isEmpty()){
            TrainBooking = TrainBookingService.getSearchTrainBookingListall(start, end, startDay, endDay);
        }else if(start.isEmpty()&&end.isEmpty()&&!startDay.isEmpty()&&!endDay.isEmpty()) {
            TrainBooking = TrainBookingService.getSearchTrainBookingListDay(startDay, endDay);
        }


        return ResponseEntity.ok(TrainBooking);
    }

    @DeleteMapping("/delete/{ticketNumber}")
    public ResponseEntity<?> deleteBusBooking(@PathVariable String ticketNumber){
        TrainBookingService.deleteTrainBooking(ticketNumber);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/getusedMileage/{ticketNumber}")
    public ResponseEntity<?> getUsedMileage(@PathVariable String ticketNumber) {
        System.out.println(ticketNumber);
        Optional<TrainBooking> trainBooking = Optional.ofNullable(TrainBookingService.getUsedMileage(ticketNumber));
        if (trainBooking.isPresent()) {
            TrainBooking trainBookingMileage = trainBooking.get();
            int usedMileage = trainBookingMileage.getUsedMileage();
            return ResponseEntity.ok(usedMileage);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

//    @GetMapping("/findSeat")
//    public ResponseEntity<List<TrainBooking>> findSeat (@ModelAttribute Seats seat)
//    {return ResponseEntity.ok(TrainBookingRepository.findBySeat(seat));}
}
