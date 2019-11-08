package com.sedbproj.Railways.Entities;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class EventEntityPK implements Serializable {
    private int managerId;
    private int routeRouteId;

    @Column(name = "ManagerId", nullable = false)
    @Id
    public int getManagerId() {
        return managerId;
    }

    public void setManagerId(int managerId) {
        this.managerId = managerId;
    }

    @Column(name = "Route_RouteId", nullable = false)
    @Id
    public int getRouteRouteId() {
        return routeRouteId;
    }

    public void setRouteRouteId(int routeRouteId) {
        this.routeRouteId = routeRouteId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EventEntityPK that = (EventEntityPK) o;
        return managerId == that.managerId &&
                routeRouteId == that.routeRouteId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(managerId, routeRouteId);
    }
}
