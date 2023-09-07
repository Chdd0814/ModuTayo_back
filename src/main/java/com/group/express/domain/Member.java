package com.group.express.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class Member {
   public Member() {

   }

   public String getId() {
      return id;
   }

   public void setId(String id) {
      this.id = id;
   }

   public String getPass() {
      return pass;
   }

   public void setPass(String pass) {
      this.pass = pass;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getPhoneNumber() {
      return phoneNumber;
   }

   public void setPhoneNumber(String phoneNumber) {
      this.phoneNumber = phoneNumber;
   }

   public int getMileage() {
      return mileage;
   }

   public void setMileage(int mileage) {
      this.mileage = mileage;
   }

   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   public String getAddress() {
      return address;
   }

   public void setAddress(String address) {
      this.address = address;
   }

   public Member(String id, String pass, String name, String phoneNumber, int mileage, String email, String address, String role) {
      this.id = id;
      this.pass = pass;
      this.name = name;
      this.phoneNumber = phoneNumber;
      this.mileage = mileage;
      this.email = email;
      this.address = address;
      this.role = role;
   }

   @Id
   @Column(name ="id")
   private String id;
   private String pass;
   private String name;
   @Column(name = "phonenumber")
   private String phoneNumber;
   private int mileage;
   private String email;
   private String address;

   public String getRole() {
      return role;
   }

   public void setRole(String role) {
      this.role = role;
   }

   private String role;

   @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
   private List<TrainBooking> trainBookings;

   @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
   private List<BusBooking> busBookings;

}
