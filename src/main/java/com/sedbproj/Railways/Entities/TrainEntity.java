package com.sedbproj.Railways.Entities;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "Train", schema = "RailwaysV3", catalog = "")
public class TrainEntity {
    private int trainId;
    private String model;
    private Timestamp issuedDate;
    private Double mileage;

    @Id
    @Column(name = "TrainId", nullable = false)
    public int getTrainId() {
        return trainId;
    }

    public void setTrainId(int trainId) {
        this.trainId = trainId;
    }

    @Basic
    @Column(name = "Model", nullable = true, length = 45)
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Basic
    @Column(name = "IssuedDate", nullable = true)
    public Timestamp getIssuedDate() {
        return issuedDate;
    }

    public void setIssuedDate(Timestamp issuedDate) {
        this.issuedDate = issuedDate;
    }

    @Basic
    @Column(name = "Mileage", nullable = true, precision = 0)
    public Double getMileage() {
        return mileage;
    }

    public void setMileage(Double mileage) {
        this.mileage = mileage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TrainEntity that = (TrainEntity) o;
        return trainId == that.trainId &&
                Objects.equals(model, that.model) &&
                Objects.equals(issuedDate, that.issuedDate) &&
                Objects.equals(mileage, that.mileage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(trainId, model, issuedDate, mileage);
    }
}
