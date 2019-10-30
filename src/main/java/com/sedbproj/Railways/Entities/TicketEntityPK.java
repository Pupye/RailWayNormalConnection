package com.sedbproj.Railways.Entities;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class TicketEntityPK implements Serializable {
    private int seatNum;
    private int cargoNum;
    private int routeHasStationRouteIdRoute;
    private int routeHasStationStationIdStation;
    private int routeHasStationStationIdStation1;

    @Column(name = "SeatNum", nullable = false)
    @Id
    public int getSeatNum() {
        return seatNum;
    }

    public void setSeatNum(int seatNum) {
        this.seatNum = seatNum;
    }

    @Column(name = "CargoNum", nullable = false)
    @Id
    public int getCargoNum() {
        return cargoNum;
    }

    public void setCargoNum(int cargoNum) {
        this.cargoNum = cargoNum;
    }

    @Column(name = "ROUTE_has_STATION_ROUTE_idROUTE", nullable = false)
    @Id
    public int getRouteHasStationRouteIdRoute() {
        return routeHasStationRouteIdRoute;
    }

    public void setRouteHasStationRouteIdRoute(int routeHasStationRouteIdRoute) {
        this.routeHasStationRouteIdRoute = routeHasStationRouteIdRoute;
    }

    @Column(name = "ROUTE_has_STATION_STATION_idSTATION", nullable = false)
    @Id
    public int getRouteHasStationStationIdStation() {
        return routeHasStationStationIdStation;
    }

    public void setRouteHasStationStationIdStation(int routeHasStationStationIdStation) {
        this.routeHasStationStationIdStation = routeHasStationStationIdStation;
    }

    @Column(name = "ROUTE_has_STATION_STATION_idSTATION1", nullable = false)
    @Id
    public int getRouteHasStationStationIdStation1() {
        return routeHasStationStationIdStation1;
    }

    public void setRouteHasStationStationIdStation1(int routeHasStationStationIdStation1) {
        this.routeHasStationStationIdStation1 = routeHasStationStationIdStation1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TicketEntityPK that = (TicketEntityPK) o;
        return seatNum == that.seatNum &&
                cargoNum == that.cargoNum &&
                routeHasStationRouteIdRoute == that.routeHasStationRouteIdRoute &&
                routeHasStationStationIdStation == that.routeHasStationStationIdStation &&
                routeHasStationStationIdStation1 == that.routeHasStationStationIdStation1;
    }

    @Override
    public int hashCode() {
        return Objects.hash(seatNum, cargoNum, routeHasStationRouteIdRoute, routeHasStationStationIdStation, routeHasStationStationIdStation1);
    }
}
