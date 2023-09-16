package com.group.express.domain;

import javax.persistence.*;
@Entity
public class Payment {

    public Payment() {

    }


    public String getBuyerid() {
        return buyerid;
    }

    public void setBuyerid(String buyerid) {
        this.buyerid = buyerid;
    }

    public String getTrainticketNumber() {
        return trainticketNumber;
    }

    public void setTrainticketNumber(String trainticketNumber) {
        this.trainticketNumber = trainticketNumber;
    }

    public String getBusticketNumber() {
        return busticketNumber;
    }

    public void setBusticketNumber(String busticketNumber) {
        this.busticketNumber = busticketNumber;
    }

    public String getImpUid() {
        return impUid;
    }

    public void setImpUid(String impUid) {
        this.impUid = impUid;
    }

    public String getMerchantUid() {
        return merchantUid;
    }

    public void setMerchantUid(String merchantUid) {
        this.merchantUid = merchantUid;
    }

    public int getPaidAmount() {
        return paidAmount;
    }

    public void setPaidAmount(int paidAmount) {
        this.paidAmount = paidAmount;
    }

    public String getPayMethod() {
        return payMethod;
    }

    public void setPayMethod(String payMethod) {
        this.payMethod = payMethod;
    }

    public String getBuyerName() {
        return buyerName;
    }

    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }

    public String getBuyerTel() {
        return buyerTel;
    }

    public void setBuyerTel(String buyerTel) {
        this.buyerTel = buyerTel;
    }

    public TrainBooking getTrainBooking() {
        return trainBooking;
    }

    public void setTrainBooking(TrainBooking trainBooking) {
        this.trainBooking = trainBooking;
    }

    public BusBooking getBusBooking() {
        return busBooking;
    }

    public void setBusBooking(BusBooking busBooking) {
        this.busBooking = busBooking;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    @Id
    private String buyerid;

    private String trainticketNumber;

    public Payment(String buyerid, String trainticketNumber, String busticketNumber, String impUid, String merchantUid, int paidAmount, String payMethod, String buyerName, String buyerTel, TrainBooking trainBooking, BusBooking busBooking, Member member) {
        this.buyerid = buyerid;
        this.trainticketNumber = trainticketNumber;
        this.busticketNumber = busticketNumber;
        this.impUid = impUid;
        this.merchantUid = merchantUid;
        this.paidAmount = paidAmount;
        this.payMethod = payMethod;
        this.buyerName = buyerName;
        this.buyerTel = buyerTel;
        this.trainBooking = trainBooking;
        this.busBooking = busBooking;
        this.member = member;
    }

    private String busticketNumber;
    private String impUid;
    private String merchantUid;
    private int paidAmount;
    private String payMethod;
    private String buyerName;
    private String buyerTel;

    @ManyToOne (cascade = CascadeType.ALL)
    @JoinColumn(name = "trainticketNumber", referencedColumnName = "ticketNumber", nullable = false, insertable = false, updatable = false)
    private TrainBooking trainBooking;

    @ManyToOne (cascade = CascadeType.ALL)
    @JoinColumn(name = "busticketNumber", referencedColumnName = "ticketNumber", nullable = false, insertable = false, updatable = false)
    private BusBooking busBooking;

    @ManyToOne (cascade = CascadeType.ALL)
    @JoinColumn(name = "buyerid", referencedColumnName = "id", nullable = false, insertable = false, updatable = false )
    private Member member;
}