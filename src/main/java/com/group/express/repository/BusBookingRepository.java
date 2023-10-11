package com.group.express.repository;

import com.group.express.domain.BusBooking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BusBookingRepository extends JpaRepository<BusBooking, String>  {

    @Query("SELECT b FROM BusBooking b WHERE b.member.id = :id")
    List<BusBooking> findBookingsById(@Param("id") String id);
}
