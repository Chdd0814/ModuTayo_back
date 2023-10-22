package com.group.express.controller;

import ch.qos.logback.core.CoreConstants;
import com.group.express.domain.BusBooking;
import com.group.express.domain.Member;
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
    public ResponseEntity<String> handlebusTicketSuccess (@RequestBody BusBooking busBooking) {
        try {
            BusBookingService.busTicketSuccess(busBooking);
            return ResponseEntity.ok("busTicket DB Save success");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("busTicket DB Save failed");
        }
    }
    @DeleteMapping("/delete/{ticketNumber}")
    public ResponseEntity<?> deleteBusBooking(@PathVariable String ticketNumber){
        BusBookingService.deleteBusBooking(ticketNumber);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/SearchFilter")
    public ResponseEntity<List<BusBooking>> getListMember(@RequestParam String id,@RequestParam(required = false) String start, @RequestParam(required = false) String end
            , @RequestParam(required = false) String startDay, @RequestParam(required = false) String endDay){
        List<BusBooking> BusBookingList=null;
        if(start.isEmpty()&&end.isEmpty()&&startDay.isEmpty()&&endDay.isEmpty()){
             BusBookingList = BusBookingService.getBusBookingList(id);

        }
        else if(!start.isEmpty()&&!end.isEmpty()&&!startDay.isEmpty()&&!endDay.isEmpty()){
             BusBookingList = BusBookingService.getSearchBusBookingListall(start, end, startDay, endDay);
        }else if(start.isEmpty()&&end.isEmpty()&&!startDay.isEmpty()&&!endDay.isEmpty()) {
            BusBookingList = BusBookingService.getSearchBusBookingListDay(startDay, endDay);
        }


        return ResponseEntity.ok(BusBookingList);
    }

}
