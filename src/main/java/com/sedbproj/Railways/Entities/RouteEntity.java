package com.sedbproj.Railways.Entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "ROUTE", schema = "Railway", catalog = "")
public class RouteEntity {
    private int idRoute;
    private String date;

    public RouteEntity(String date){
        this.date = date;
    }

    public RouteEntity() {

    }

    @Id
    @Column(name = "idROUTE", nullable = false)
    public int getIdRoute() {
        return idRoute;
    }

    public void setIdRoute(int idRoute) {
        this.idRoute = idRoute;
    }

    @Basic
    @Column(name = "Date", nullable = true, length = 45)
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RouteEntity that = (RouteEntity) o;
        return idRoute == that.idRoute &&
                Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idRoute, date);
    }
}
