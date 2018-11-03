package com.home.gou.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "PTRIP", schema = "kqnData", catalog = "")
public class PtripEntity {
    private int id;
    private int tripId;
    private int userId;

    @Id
    @Column(name = "Id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "TRIP_ID", nullable = false)
    public int getTripId() {
        return tripId;
    }

    public void setTripId(int tripId) {
        this.tripId = tripId;
    }

    @Basic
    @Column(name = "USER_ID", nullable = false)
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PtripEntity that = (PtripEntity) o;
        return id == that.id &&
                tripId == that.tripId &&
                userId == that.userId;
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, tripId, userId);
    }
}
