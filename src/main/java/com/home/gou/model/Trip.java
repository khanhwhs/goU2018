package com.home.gou.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@Getter
@Setter
public class Trip {
    private int tripId;
    private Integer userCarId;
    @JsonProperty("createdOn")
    private String createdOn;
    @JsonProperty("seats")
    private Integer seats;
    @JsonProperty("destAddrId")
    private String destAddrId;
    @JsonProperty("startAddrId")
    private String startAddrId;
    @JsonProperty("startTime")
    private String startTime;
    @JsonProperty("carId")
    private Integer carId;
    @JsonProperty("luggageDesc")
    private String luggageDesc;
    @JsonProperty("isRoundTrip")
    private String isRoundTrip;
    @JsonProperty("passengers")
    private String passengers;
    @JsonProperty("tripCost")
    private String tripCost;

    private User driver;

    private List<User> passengerList;

    public Trip(){

    }
}
