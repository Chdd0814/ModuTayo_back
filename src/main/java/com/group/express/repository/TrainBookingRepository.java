package com.group.express.repository;

import com.group.express.domain.BusBooking;
import com.group.express.domain.Seats;
import com.group.express.domain.TrainBooking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TrainBookingRepository extends JpaRepository<TrainBooking, String> {

    @Query("SELECT t FROM TrainBooking t WHERE t.member.id = :id")
    List<TrainBooking> findBookingsById(@Param("id") String id);

//    @Query("SELECT tb FROM TrainBooking tb WHERE " +
//            "tb.vehicleTypeName = :vehicleTypeName " +
//            "AND tb.departureTime = :departureTime " +
//            "AND tb.arrivalTime = :arrivalTime " +
//            "AND tb.departureStation = :departureStation " +
//            "AND tb.arrivalStation = :arrivalStation " +
//            "AND tb.trainNumber = :trainNumber " +
//            "AND tb.reservationDate = :reservationDate")
//    List<TrainBooking> findBySeat(Seats seat);
}
