package com.group.express.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(name = "trainbooking")
public class TrainBooking {

    private String vehicleTypeName;
    private Timestamp departureTime;
    private Timestamp arrivalTime;
    private String departureStation;
    private String arrivalStation;
    private int fare;
    private String trainNumber;
    private String seatNumber;
    private int trainCarNumber;
    @Id
    private String ticketNumber;
    private String compartment;
    private String id;
    private String name;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    private Member member;

}