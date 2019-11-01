package com.sedbproj.Railways.Entities;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class CarriageEntityPK implements Serializable {
    private int carriageId;
    private int trainId;


    @Column(name = "CarriageId", nullable = false)
    @Id
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarriageEntityPK that = (CarriageEntityPK) o;
        return carriageId == that.getCarriageId() &&
                trainId == that.trainId;
    }

    @Override
    public int hashCode() {
        return Objects.hash( carriageId, trainId);
    }
}
