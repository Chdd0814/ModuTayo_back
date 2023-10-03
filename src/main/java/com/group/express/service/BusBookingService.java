package com.group.express.service;

import com.group.express.domain.BusBooking;
import com.group.express.repository.BusBookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusBookingService {
    private final BusBookingRepository busBookingRepository;
    @Autowired
    BusBookingService(BusBookingRepository busBookingRepository){this.busBookingRepository=busBookingRepository;}

    public List<BusBooking> getBusBookingList(String id ){
        return busBookingRepository.findBookingsById(id);
    }


}
