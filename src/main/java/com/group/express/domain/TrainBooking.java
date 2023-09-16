package com.group.express.domain;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;
@Entity
public class TrainBooking {

    public TrainBooking() {

    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getVehicleTypeName() {
        return vehicleTypeName;
    }

    public void setVehicleTypeName(String vehicleTypeName) {
        this.vehicleTypeName = vehicleTypeName;
    }

    public Timestamp getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Timestamp departureTime) {
        this.departureTime = departureTime;
    }

    public Timestamp getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(Timestamp arrivalTime) {
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

    public String getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(String ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public String getCompartment() {
        return compartment;
    }

    public void setCompartment(String compartment) {
        this.compartment = compartment;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    @Id
    private String id;

    public TrainBooking(String id, String vehicleTypeName, Timestamp departureTime, Timestamp arrivalTime, String departureStation, String arrivalStation, int fare, String trainNumber, String seatNumber, int trainCarNumber, String ticketNumber, String compartment, Member member) {
        this.id = id;
        this.vehicleTypeName = vehicleTypeName;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.departureStation = departureStation;
        this.arrivalStation = arrivalStation;
        this.fare = fare;
        this.trainNumber = trainNumber;
        this.seatNumber = seatNumber;
        this.trainCarNumber = trainCarNumber;
        this.ticketNumber = ticketNumber;
        this.compartment = compartment;
        this.member = member;
    }

    private String vehicleTypeName;
    private Timestamp departureTime;
    private Timestamp arrivalTime;
    private String departureStation;
    private String arrivalStation;
    private int fare;
    private String trainNumber;
    private String seatNumber;
    private int trainCarNumber;
    private String ticketNumber;
    private String compartment;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    private Member member;

}