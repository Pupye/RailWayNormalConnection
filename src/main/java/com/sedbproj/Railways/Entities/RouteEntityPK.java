package com.sedbproj.Railways.Entities;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class RouteEntityPK implements Serializable {
    private int routeId;
    private int stationId;
    private int trainId;

    @Column(name = "RouteId", nullable = false)
    @Id
    public int getRouteId() {
        return routeId;
    }

    public void setRouteId(int routeId) {
        this.routeId = routeId;
    }

    @Column(name = "StationId", nullable = false)
    @Id
    public int getStationId() {
        return stationId;
    }

    public void setStationId(int stationId) {
        this.stationId = stationId;
    }

    @Column(name = "TrainId", nullable = false)
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
        RouteEntityPK that = (RouteEntityPK) o;
        return routeId == that.routeId &&
                stationId == that.stationId &&
                trainId == that.trainId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(routeId, stationId, trainId);
    }
}
