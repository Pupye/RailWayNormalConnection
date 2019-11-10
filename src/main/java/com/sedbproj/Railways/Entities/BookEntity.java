package com.sedbproj.Railways.Entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Book", schema = "RailwaysV3", catalog = "")
@IdClass(BookEntityPK.class)
public class BookEntity {
    private int routeId;
    private int arriveStationId;
    private int departStationId1;
    private int carriageId;
    private int seatNum;
    private long ssn;
    private Double price;
    private Byte adult;
    public BookEntity(){

    }

    public BookEntity(int routeId, int arriveStationId, int departStationId1, int carriageId, int seatNum, long ssn, Double price, Byte adult) {
        this.routeId = routeId;
        this.arriveStationId = arriveStationId;
        this.departStationId1 = departStationId1;
        this.carriageId = carriageId;
        this.seatNum = seatNum;
        this.ssn = ssn;
        this.price = price;
        this.adult = adult;
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
    @Column(name = "Arrive_StationId", nullable = false)
    public int getArriveStationId() {
        return arriveStationId;
    }

    public void setArriveStationId(int arriveStationId) {
        this.arriveStationId = arriveStationId;
    }

    @Id
    @Column(name = "Depart_StationId1", nullable = false)
    public int getDepartStationId1() {
        return departStationId1;
    }

    public void setDepartStationId1(int departStationId1) {
        this.departStationId1 = departStationId1;
    }

    @Id
    @Column(name = "CarriageId", nullable = false)
    public int getCarriageId() {
        return carriageId;
    }

    public void setCarriageId(int carriageId) {
        this.carriageId = carriageId;
    }

    @Id
    @Column(name = "SeatNum", nullable = false)
    public int getSeatNum() {
        return seatNum;
    }

    public void setSeatNum(int seatNum) {
        this.seatNum = seatNum;
    }

    @Id
    @Column(name = "SSN", nullable = false)
    public long getSsn() {
        return ssn;
    }

    public void setSsn(long ssn) {
        this.ssn = ssn;
    }

    @Basic
    @Column(name = "Price", nullable = true, precision = 0)
    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Basic
    @Column(name = "Adult", nullable = true)
    public Byte getAdult() {
        return adult;
    }

    public void setAdult(Byte adult) {
        this.adult = adult;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookEntity that = (BookEntity) o;
        return routeId == that.routeId &&
                arriveStationId == that.arriveStationId &&
                departStationId1 == that.departStationId1 &&
                carriageId == that.carriageId &&
                seatNum == that.seatNum &&
                ssn == that.ssn &&
                Objects.equals(price, that.price) &&
                Objects.equals(adult, that.adult);
    }

    @Override
    public int hashCode() {
        return Objects.hash(routeId, arriveStationId, departStationId1, carriageId, seatNum, ssn, price, adult);
    }
}
