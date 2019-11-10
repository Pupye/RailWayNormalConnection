package com.sedbproj.Railways.Entities;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "Route", schema = "RailwaysV3", catalog = "")
@IdClass(RouteEntityPK.class)
public class RouteEntity {
    private int routeId;
    private int stationId;
    private int trainId;
    private Timestamp arrDate;
    private Timestamp depDate;
    private int ordering;

    public RouteEntity(){

    }

    public RouteEntity(int routeId, int stationId, int trainId, Timestamp arrDate, Timestamp depDate, int ordering) {
        this.routeId = routeId;
        this.stationId = stationId;
        this.trainId = trainId;
        this.arrDate = arrDate;
        this.depDate = depDate;
        this.ordering = ordering;
    }

    public RouteEntity(int stationId, int trainId, Timestamp arrDate, Timestamp depDate, int ordering) {
        this.routeId = routeId;
        this.stationId = stationId;
        this.trainId = trainId;
        this.arrDate = arrDate;
        this.depDate = depDate;
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
    @Column(name = "ArrDate")
    public Timestamp getArrDate() {
        return arrDate;
    }

    public void setArrDate(Timestamp arrDate) {
        this.arrDate = arrDate;
    }

    @Basic
    @Column(name = "DepDate")
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
                Objects.equals(depDate, that.depDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(routeId, stationId, trainId, arrDate, depDate, ordering);
    }
}
