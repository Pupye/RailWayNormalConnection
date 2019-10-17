package com.sedbproj.Railways;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "TRAIN", schema = "Railway", catalog = "")
public class TrainEntity {
    private int idTrain;
    private int capacity;
    private String model;
    private double mileage;
    private Timestamp issuedDate;
    private Integer maxCargoCap;

    @Id
    @Column(name = "idTRAIN", nullable = false)
    public int getIdTrain() {
        return idTrain;
    }

    public void setIdTrain(int idTrain) {
        this.idTrain = idTrain;
    }

    @Basic
    @Column(name = "Capacity", nullable = false)
    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Basic
    @Column(name = "Model", nullable = false, length = 45)
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Basic
    @Column(name = "Mileage", nullable = false, precision = 0)
    public double getMileage() {
        return mileage;
    }

    public void setMileage(double mileage) {
        this.mileage = mileage;
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
    @Column(name = "MaxCargoCap", nullable = true)
    public Integer getMaxCargoCap() {
        return maxCargoCap;
    }

    public void setMaxCargoCap(Integer maxCargoCap) {
        this.maxCargoCap = maxCargoCap;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TrainEntity that = (TrainEntity) o;
        return idTrain == that.idTrain &&
                capacity == that.capacity &&
                Double.compare(that.mileage, mileage) == 0 &&
                Objects.equals(model, that.model) &&
                Objects.equals(issuedDate, that.issuedDate) &&
                Objects.equals(maxCargoCap, that.maxCargoCap);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idTrain, capacity, model, mileage, issuedDate, maxCargoCap);
    }
}
