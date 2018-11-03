package com.home.gou.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "TRIP", schema = "kqnData", catalog = "")
public class TripEntity {
    private int tripId;
    private Integer userCarId;
    private String createdOn;
    private Integer seats;
    private String destAddrId;
    private String startAddrId;
    private String startTime;
    private Integer carId;
    private String luggageDesc;
    private String isRoundTrip;
    private String passengers;
    private String tripCost;

    @Id
    @Column(name = "TRIP_ID", nullable = false)
    public int getTripId() {
        return tripId;
    }

    public void setTripId(int tripId) {
        this.tripId = tripId;
    }

    @Basic
    @Column(name = "USER_CAR_ID", nullable = true)
    public Integer getUserCarId() {
        return userCarId;
    }

    public void setUserCarId(Integer userCarId) {
        this.userCarId = userCarId;
    }

    @Basic
    @Column(name = "CREATED_ON", nullable = true, length = 50)
    public String getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(String createdOn) {
        this.createdOn = createdOn;
    }

    @Basic
    @Column(name = "SEATS", nullable = true)
    public Integer getSeats() {
        return seats;
    }

    public void setSeats(Integer seats) {
        this.seats = seats;
    }

    @Basic
    @Column(name = "DEST_ADDR_ID", nullable = true, length = 200)
    public String getDestAddrId() {
        return destAddrId;
    }

    public void setDestAddrId(String destAddrId) {
        this.destAddrId = destAddrId;
    }

    @Basic
    @Column(name = "START_ADDR_ID", nullable = true, length = 200)
    public String getStartAddrId() {
        return startAddrId;
    }

    public void setStartAddrId(String startAddrId) {
        this.startAddrId = startAddrId;
    }

    @Basic
    @Column(name = "START_TIME", nullable = true, length = 50)
    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    @Basic
    @Column(name = "CAR_ID", nullable = true)
    public Integer getCarId() {
        return carId;
    }

    public void setCarId(Integer carId) {
        this.carId = carId;
    }

    @Basic
    @Column(name = "LUGGAGE_DESC", nullable = true, length = 200)
    public String getLuggageDesc() {
        return luggageDesc;
    }

    public void setLuggageDesc(String luggageDesc) {
        this.luggageDesc = luggageDesc;
    }

    @Basic
    @Column(name = "IS_ROUND_TRIP", nullable = true, length = 1)
    public String getIsRoundTrip() {
        return isRoundTrip;
    }

    public void setIsRoundTrip(String isRoundTrip) {
        this.isRoundTrip = isRoundTrip;
    }

    @Basic
    @Column(name = "PASSENGERS", nullable = true, length = 250)
    public String getPassengers() {
        return passengers;
    }

    public void setPassengers(String passengers) {
        this.passengers = passengers;
    }

    @Basic
    @Column(name = "TRIP_COST", nullable = true, length = 50)
    public String getTripCost() {
        return tripCost;
    }

    public void setTripCost(String tripCost) {
        this.tripCost = tripCost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TripEntity that = (TripEntity) o;
        return tripId == that.tripId &&
                Objects.equals(userCarId, that.userCarId) &&
                Objects.equals(createdOn, that.createdOn) &&
                Objects.equals(seats, that.seats) &&
                Objects.equals(destAddrId, that.destAddrId) &&
                Objects.equals(startAddrId, that.startAddrId) &&
                Objects.equals(startTime, that.startTime) &&
                Objects.equals(carId, that.carId) &&
                Objects.equals(luggageDesc, that.luggageDesc) &&
                Objects.equals(isRoundTrip, that.isRoundTrip) &&
                Objects.equals(passengers, that.passengers) &&
                Objects.equals(tripCost, that.tripCost);
    }

    @Override
    public int hashCode() {

        return Objects.hash(tripId, userCarId, createdOn, seats, destAddrId, startAddrId, startTime, carId, luggageDesc, isRoundTrip, passengers, tripCost);
    }
}
