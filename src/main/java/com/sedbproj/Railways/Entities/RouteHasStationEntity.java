package com.sedbproj.Railways.Entities;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "ROUTE_has_STATION", schema = "Railway", catalog = "")
@IdClass(RouteHasStationEntityPK.class)
public class RouteHasStationEntity {
    private int routeIdRoute;
    private int stationIdStation;
    private int order;
    private int capacity;
    private Timestamp departureTime;
    private Timestamp arrivalTime;

    public RouteHasStationEntity(int routeIdRoute, int stationIdStation, int order, int capacity, Timestamp departureTime, Timestamp arrivalTime) {
        this.routeIdRoute = routeIdRoute;
        this.stationIdStation = stationIdStation;
        this.order = order;
        this.capacity = capacity;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
    }

    public RouteHasStationEntity() {

    }

    @Id
    @Column(name = "ROUTE_idROUTE", nullable = false)
    public int getRouteIdRoute() {
        return routeIdRoute;
    }

    public void setRouteIdRoute(int routeIdRoute) {
        this.routeIdRoute = routeIdRoute;
    }

    @Id
    @Column(name = "STATION_idSTATION", nullable = false)
    public int getStationIdStation() {
        return stationIdStation;
    }

    public void setStationIdStation(int stationIdStation) {
        this.stationIdStation = stationIdStation;
    }

    @Basic
    @Column(name = "Ordering", nullable = false)
    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
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
    @Column(name = "DepartureTime", nullable = false)
    public Timestamp getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Timestamp departureTime) {
        this.departureTime = departureTime;
    }

    @Basic
    @Column(name = "ArrivalTime", nullable = false)
    public Timestamp getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(Timestamp arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RouteHasStationEntity that = (RouteHasStationEntity) o;
        return routeIdRoute == that.routeIdRoute &&
                stationIdStation == that.stationIdStation &&
                order == that.order &&
                capacity == that.capacity &&
                Objects.equals(departureTime, that.departureTime) &&
                Objects.equals(arrivalTime, that.arrivalTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(routeIdRoute, stationIdStation, order, capacity, departureTime, arrivalTime);
    }
}
