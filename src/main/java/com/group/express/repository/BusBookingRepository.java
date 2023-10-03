package com.group.express.repository;

import com.group.express.domain.BusBooking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BusBookingRepository extends JpaRepository<BusBooking, String>  {

    @Query("SELECT b FROM BusBooking b WHERE b.id = ?1")
    List<BusBooking> findBookingsById(String id);
}
