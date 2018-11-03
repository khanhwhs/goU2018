package com.home.gou.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "REQUEST", schema = "kqnData", catalog = "")
public class RequestEntity {
    private int id;
    private Integer requesterId;
    private Integer tripId;
    private Integer enrouteAddr;
    private Date createdOn;
    private Integer requestStatus;

    @Id
    @Column(name = "ID", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "REQUESTER_ID", nullable = true)
    public Integer getRequesterId() {
        return requesterId;
    }

    public void setRequesterId(Integer requesterId) {
        this.requesterId = requesterId;
    }

    @Basic
    @Column(name = "TRIP_ID", nullable = true)
    public Integer getTripId() {
        return tripId;
    }

    public void setTripId(Integer tripId) {
        this.tripId = tripId;
    }

    @Basic
    @Column(name = "ENROUTE_ADDR", nullable = true)
    public Integer getEnrouteAddr() {
        return enrouteAddr;
    }

    public void setEnrouteAddr(Integer enrouteAddr) {
        this.enrouteAddr = enrouteAddr;
    }

    @Basic
    @Column(name = "CREATED_ON", nullable = true)
    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    @Basic
    @Column(name = "REQUEST__STATUS", nullable = true)
    public Integer getRequestStatus() {
        return requestStatus;
    }

    public void setRequestStatus(Integer requestStatus) {
        this.requestStatus = requestStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RequestEntity that = (RequestEntity) o;
        return id == that.id &&
                Objects.equals(requesterId, that.requesterId) &&
                Objects.equals(tripId, that.tripId) &&
                Objects.equals(enrouteAddr, that.enrouteAddr) &&
                Objects.equals(createdOn, that.createdOn) &&
                Objects.equals(requestStatus, that.requestStatus);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, requesterId, tripId, enrouteAddr, createdOn, requestStatus);
    }
}
