package com.sedbproj.Railways.Entities;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class BookEntityPK implements Serializable {
    private int routeId;
    private int arriveStationId;
    private int departStationId1;
    private int carriageId;
    private int seatNum;
    private int ssn;

    @Column(name = "RouteId", nullable = false)
    @Id
    public int getRouteId() {
        return routeId;
    }

    public void setRouteId(int routeId) {
        this.routeId = routeId;
    }

    @Column(name = "Arrive_StationId", nullable = false)
    @Id
    public int getArriveStationId() {
        return arriveStationId;
    }

    public void setArriveStationId(int arriveStationId) {
        this.arriveStationId = arriveStationId;
    }

    @Column(name = "Depart_StationId1", nullable = false)
    @Id
    public int getDepartStationId1() {
        return departStationId1;
    }

    public void setDepartStationId1(int departStationId1) {
        this.departStationId1 = departStationId1;
    }

    @Column(name = "CarriageId", nullable = false)
    @Id
    public int getCarriageId() {
        return carriageId;
    }

    public void setCarriageId(int carriageId) {
        this.carriageId = carriageId;
    }

    @Column(name = "SeatNum", nullable = false)
    @Id
    public int getSeatNum() {
        return seatNum;
    }

    public void setSeatNum(int seatNum) {
        this.seatNum = seatNum;
    }

    @Column(name = "SSN", nullable = false)
    @Id
    public int getSsn() {
        return ssn;
    }

    public void setSsn(int ssn) {
        this.ssn = ssn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookEntityPK that = (BookEntityPK) o;
        return routeId == that.routeId &&
                arriveStationId == that.arriveStationId &&
                departStationId1 == that.departStationId1 &&
                carriageId == that.carriageId &&
                seatNum == that.seatNum &&
                ssn == that.ssn;
    }

    @Override
    public int hashCode() {
        return Objects.hash(routeId, arriveStationId, departStationId1, carriageId, seatNum, ssn);
    }
}
