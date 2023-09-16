package com.group.express.domain;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;
@Entity
public class BusBooking {

    public BusBooking() {

    }
    @Id
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getRouteId() {
        return routeId;
    }

    public void setRouteId(int routeId) {
        this.routeId = routeId;
    }

    public String getBusClass() {
        return busClass;
    }

    public void setBusClass(String busClass) {
        this.busClass = busClass;
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

    public String getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(String ticketNumber) {
        this.ticketNumber = ticketNumber;
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

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public int getFare() {
        return fare;
    }

    public void setFare(int fare) {
        this.fare = fare;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public BusBooking(String id, int routeId, String busClass, Timestamp departureTime, Timestamp arrivalTime, String ticketNumber, String departureStation, String arrivalStation, String seatNumber, int fare, Member member) {
        this.id = id;
        this.routeId = routeId;
        this.busClass = busClass;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.ticketNumber = ticketNumber;
        this.departureStation = departureStation;
        this.arrivalStation = arrivalStation;
        this.seatNumber = seatNumber;
        this.fare = fare;
        this.member = member;
    }

    private int routeId;
    private String busClass;
    private Timestamp departureTime;
    private Timestamp arrivalTime;
    private String ticketNumber;
    private String departureStation;
    private String arrivalStation;
    private String seatNumber;
    private int fare;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    private Member member;

}
