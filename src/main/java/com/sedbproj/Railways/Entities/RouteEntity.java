package com.sedbproj.Railways.Entities;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "Route", schema = "RailwaysV2", catalog = "")
@IdClass(RouteEntityPK.class)
public class RouteEntity {
    private int routeId;
    private int stationId;
    private int trainId;
    private Timestamp arrDate;
    private Timestamp depDate;
    private int ordering;
    private Byte cancelled;
    private String cancelDesc;
    private Timestamp cancelDate;

    public RouteEntity(){

    }

    public RouteEntity(Integer stationId,
                       Integer trainId,
                       Timestamp arrTime,
                       Timestamp depTime,
                       Integer ordering) {
        this.stationId = stationId;
        this.trainId = trainId;
        this.arrDate = arrTime;
        this.depDate = depTime;
        this.ordering = ordering;
    }

    public RouteEntity(Integer routeId,
                       Integer stationId,
                       Integer trainId,
                       Timestamp arrTime,
                       Timestamp depTime,
                       Integer ordering) {
        this.routeId = routeId;
        this.stationId = stationId;
        this.trainId = trainId;
        this.arrDate = arrTime;
        this.depDate = depTime;
        this.ordering = ordering;
    }

    @Id
    @Column(name = "RouteId", nullable = false)
    public int getRouteId() {
        return routeId;
    }

    public void setRouteId(int routeId) {
        this.routeId = routeId;
    }

    @Id
    @Column(name = "StationId", nullable = false)
    public int getStationId() {
        return stationId;
    }

    public void setStationId(int stationId) {
        this.stationId = stationId;
    }

    @Id
    @Column(name = "TrainId", nullable = false)
    public int getTrainId() {
        return trainId;
    }

    public void setTrainId(int trainId) {
        this.trainId = trainId;
    }

    @Basic
    @Column(name = "ArrDate", nullable = false)
    public Timestamp getArrDate() {
        return arrDate;
    }

    public void setArrDate(Timestamp arrDate) {
        this.arrDate = arrDate;
    }

    @Basic
    @Column(name = "DepDate", nullable = false)
    public Timestamp getDepDate() {
        return depDate;
    }

    public void setDepDate(Timestamp depDate) {
        this.depDate = depDate;
    }

    @Basic
    @Column(name = "Ordering", nullable = false)
    public int getOrdering() {
        return ordering;
    }

    public void setOrdering(int ordering) {
        this.ordering = ordering;
    }

    @Basic
    @Column(name = "Cancelled", nullable = true)
    public Byte getCancelled() {
        return cancelled;
    }

    public void setCancelled(Byte cancelled) {
        this.cancelled = cancelled;
    }

    @Basic
    @Column(name = "CancelDesc", nullable = true, length = 100)
    public String getCancelDesc() {
        return cancelDesc;
    }

    public void setCancelDesc(String cancelDesc) {
        this.cancelDesc = cancelDesc;
    }

    @Basic
    @Column(name = "CancelDate", nullable = true)
    public Timestamp getCancelDate() {
        return cancelDate;
    }

    public void setCancelDate(Timestamp cancelDate) {
        this.cancelDate = cancelDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RouteEntity that = (RouteEntity) o;
        return routeId == that.routeId &&
                stationId == that.stationId &&
                trainId == that.trainId &&
                ordering == that.ordering &&
                Objects.equals(arrDate, that.arrDate) &&
                Objects.equals(depDate, that.depDate) &&
                Objects.equals(cancelled, that.cancelled) &&
                Objects.equals(cancelDesc, that.cancelDesc) &&
                Objects.equals(cancelDate, that.cancelDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(routeId, stationId, trainId, arrDate, depDate, ordering, cancelled, cancelDesc, cancelDate);
    }
}
