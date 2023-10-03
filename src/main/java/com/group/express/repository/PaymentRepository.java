package com.group.express.repository;

import com.group.express.domain.BusBooking;
import com.group.express.domain.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long>  {

    @Query("SELECT p FROM Payment p WHERE p.buyerid = ?1")
    List<Payment> findPaymentsById(String id);
}
