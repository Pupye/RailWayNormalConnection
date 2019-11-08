package com.sedbproj.Railways.Entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Event", schema = "RailwaysV3", catalog = "")
@IdClass(EventEntityPK.class)
public class EventEntity {
    private int managerId;
    private int routeRouteId;
    private String type;
    private String description;

    @Id
    @Column(name = "ManagerId", nullable = false)
    public int getManagerId() {
        return managerId;
    }

    public void setManagerId(int managerId) {
        this.managerId = managerId;
    }

    @Id
    @Column(name = "Route_RouteId", nullable = false)
    public int getRouteRouteId() {
        return routeRouteId;
    }

    public void setRouteRouteId(int routeRouteId) {
        this.routeRouteId = routeRouteId;
    }

    @Basic
    @Column(name = "Type", nullable = true, length = 45)
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Basic
    @Column(name = "Description", nullable = true, length = 45)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EventEntity that = (EventEntity) o;
        return managerId == that.managerId &&
                routeRouteId == that.routeRouteId &&
                Objects.equals(type, that.type) &&
                Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(managerId, routeRouteId, type, description);
    }
}
