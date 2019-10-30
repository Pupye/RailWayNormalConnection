package com.sedbproj.Railways.Entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "TICKET", schema = "Railway", catalog = "")
@IdClass(TicketEntityPK.class)
public class TicketEntity {
    private int seatNum;
    private int cargoNum;
    private Double price;
    private int routeHasStationRouteIdRoute;
    private int routeHasStationStationIdStation;
    private int routeHasStationStationIdStation1;

    @Id
    @Column(name = "SeatNum", nullable = false)
    public int getSeatNum() {
        return seatNum;
    }

    public void setSeatNum(int seatNum) {
        this.seatNum = seatNum;
    }

    @Id
    @Column(name = "CargoNum", nullable = false)
    public int getCargoNum() {
        return cargoNum;
    }

    public void setCargoNum(int cargoNum) {
        this.cargoNum = cargoNum;
    }

    @Basic
    @Column(name = "Price", nullable = true, precision = 0)
    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Id
    @Column(name = "ROUTE_has_STATION_ROUTE_idROUTE", nullable = false)
    public int getRouteHasStationRouteIdRoute() {
        return routeHasStationRouteIdRoute;
    }

    public void setRouteHasStationRouteIdRoute(int routeHasStationRouteIdRoute) {
        this.routeHasStationRouteIdRoute = routeHasStationRouteIdRoute;
    }

    @Id
    @Column(name = "ROUTE_has_STATION_STATION_idSTATION", nullable = false)
    public int getRouteHasStationStationIdStation() {
        return routeHasStationStationIdStation;
    }

    public void setRouteHasStationStationIdStation(int routeHasStationStationIdStation) {
        this.routeHasStationStationIdStation = routeHasStationStationIdStation;
    }

    @Id
    @Column(name = "ROUTE_has_STATION_STATION_idSTATION1", nullable = false)
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
        TicketEntity that = (TicketEntity) o;
        return seatNum == that.seatNum &&
                cargoNum == that.cargoNum &&
                routeHasStationRouteIdRoute == that.routeHasStationRouteIdRoute &&
                routeHasStationStationIdStation == that.routeHasStationStationIdStation &&
                routeHasStationStationIdStation1 == that.routeHasStationStationIdStation1 &&
                Objects.equals(price, that.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(seatNum, cargoNum, price, routeHasStationRouteIdRoute, routeHasStationStationIdStation, routeHasStationStationIdStation1);
    }
}
