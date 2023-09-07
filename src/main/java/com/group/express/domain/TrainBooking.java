package com.group.express.domain;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.*;
import java.time.LocalDateTime;
@Entity
public class TrainBooking {
    public String getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(String ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public String getVehicleTypeName() {
        return vehicleTypeName;
    }

    public void setVehicleTypeName(String vehicleTypeName) {
        this.vehicleTypeName = vehicleTypeName;
    }

    public LocalDateTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalDateTime departureTime) {
        this.departureTime = departureTime;
    }

    public LocalDateTime getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(LocalDateTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public String getDepartureStation() {
        return departureStation;
    }

    public void setDepartureStation(String departureStation) {
        this.departureStation = departureStation;
    }

    public String getArrivalStation() {
        return arrivalStation;
    }

    public void setArrivalStation(String arrivalStation) {
        this.arrivalStation = arrivalStation;
    }

    public int getFare() {
        return fare;
    }

    public void setFare(int fare) {
        this.fare = fare;
    }

    public String getTrainNumber() {
        return trainNumber;
    }

    public void setTrainNumber(String trainNumber) {
        this.trainNumber = trainNumber;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public int getTrainCarNumber() {
        return trainCarNumber;
    }

    public void setTrainCarNumber(int trainCarNumber) {
        this.trainCarNumber = trainCarNumber;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    @Id
    private String ticketNumber;
    private String vehicleTypeName;
    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;
    private String departureStation;
    private String arrivalStation;
    private int fare;
    private String trainNumber;
    private String seatNumber;

    public TrainBooking(String ticketNumber, String vehicleTypeName, LocalDateTime departureTime, LocalDateTime arrivalTime, String departureStation, String arrivalStation, int fare, String trainNumber, String seatNumber, int trainCarNumber, Member member) {
        this.ticketNumber = ticketNumber;
        this.vehicleTypeName = vehicleTypeName;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.departureStation = departureStation;
        this.arrivalStation = arrivalStation;
        this.fare = fare;
        this.trainNumber = trainNumber;
        this.seatNumber = seatNumber;
        this.trainCarNumber = trainCarNumber;
        this.member = member;
    }
public TrainBooking() {

}
    private int trainCarNumber;
    @ManyToOne
    @JoinColumn(name = "id")
    private Member member;
}
