package com.group.express.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(name = "busbooking")
public class BusBooking {



    private String routeId;
    private String busClass;
    private String departureTime;
    private String arrivalTime;
    @Id
    private String ticketNumber;
    private String departureStation;
    private String arrivalStation;
    private String seatNumber;
    private int fare;
    private String id;
    private String name;
    private String reservationDate;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    private Member member;

}

