package com.sedbproj.Railways.Entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Station", schema = "RailwaysV3", catalog = "")
public class StationEntity {
    private int stationId;
    private String name;
    private String city;
    private Double lat;
    private Double lon;

    @Id
    @Column(name = "StationId", nullable = false)
    public int getStationId() {
        return stationId;
    }

    public void setStationId(int stationId) {
        this.stationId = stationId;
    }

    @Basic
    @Column(name = "Name", nullable = true, length = 45)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "City", nullable = false, length = 45)
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Basic
    @Column(name = "Lat", nullable = true, precision = 0)
    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    @Basic
    @Column(name = "Lon", nullable = true, precision = 0)
    public Double getLon() {
        return lon;
    }

    public void setLon(Double lon) {
        this.lon = lon;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StationEntity that = (StationEntity) o;
        return stationId == that.stationId &&
                Objects.equals(name, that.name) &&
                Objects.equals(city, that.city) &&
                Objects.equals(lat, that.lat) &&
                Objects.equals(lon, that.lon);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stationId, name, city, lat, lon);
    }
}
