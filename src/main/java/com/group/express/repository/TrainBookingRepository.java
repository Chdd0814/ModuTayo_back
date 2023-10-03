package com.group.express.repository;

import com.group.express.domain.BusBooking;
import com.group.express.domain.TrainBooking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TrainBookingRepository extends JpaRepository<TrainBooking, String> {

    @Query("SELECT t FROM TrainBooking t WHERE t.member.id = :id")
    List<TrainBooking> findBookingsById(@Param("id") String id);
}
