package com.sedbproj.Railways.Entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@IdClass(CarriageEntityPK.class)
@Table(name = "Carriage", schema = "RailwaysV2", catalog = "")
public class CarriageEntity {
    private int carriageId;
    private String type;
    private int totalSeats;
    private int trainId;

    @Id
    @Column(name = "CarriageId", nullable = false)
    public int getCarriageId() {
        return carriageId;
    }

    public void setCarriageId(int carriageId) {
        this.carriageId = carriageId;
    }

    @Column(name = "trainId", nullable = false)
    @Id
    public int getTrainId() {
        return trainId;
    }

    public void setTrainId(int trainId) {
        this.trainId = trainId;
    }


    @Basic
    @Column(name = "Type", nullable = true, length = 45)
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Basic
    @Column(name = "TotalSeats", nullable = false)
    public int getTotalSeats() {
        return totalSeats;
    }

    public void setTotalSeats(int totalSeats) {
        this.totalSeats = totalSeats;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarriageEntity that = (CarriageEntity) o;
        return carriageId == that.carriageId &&
                totalSeats == that.totalSeats &&
                Objects.equals(type, that.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carriageId, type, totalSeats);
    }
}
