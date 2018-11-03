package com.home.gou.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Data
@AllArgsConstructor
@Getter
@Setter
public class Request {
    private int id;
    @JsonProperty("requesterId")
    private Integer requesterId;
    @JsonProperty("tripId")
    private Integer tripId;
    @JsonProperty("enrouteAddr")
    private Integer enrouteAddr;
    @JsonProperty("createdOn")
    private Date createdOn;
    @JsonProperty("requestStatus")
    private Integer requestStatus;
}
