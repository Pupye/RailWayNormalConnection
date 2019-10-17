package com.sedbproj.Railways;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class RouteHasStationEntityPK implements Serializable {
    private int routeIdRoute;
    private int stationIdStation;

    @Column(name = "ROUTE_idROUTE", nullable = false)
    @Id
    public int getRouteIdRoute() {
        return routeIdRoute;
    }

    public void setRouteIdRoute(int routeIdRoute) {
        this.routeIdRoute = routeIdRoute;
    }

    @Column(name = "STATION_idSTATION", nullable = false)
    @Id
    public int getStationIdStation() {
        return stationIdStation;
    }

    public void setStationIdStation(int stationIdStation) {
        this.stationIdStation = stationIdStation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RouteHasStationEntityPK that = (RouteHasStationEntityPK) o;
        return routeIdRoute == that.routeIdRoute &&
                stationIdStation == that.stationIdStation;
    }

    @Override
    public int hashCode() {
        return Objects.hash(routeIdRoute, stationIdStation);
    }
}
