package com.sedbproj.Railways.Wrappers.bookWrappers;


import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "RouteID",
        "Arrive_StationID",
        "Depart_StationID",
        "CarriageID",
        "SeatNum",
        "SSN"
})
public class BookCancel {

    @JsonProperty("RouteID")
    private Integer routeID;
    @JsonProperty("Arrive_StationID")
    private Integer arriveStationID;
    @JsonProperty("Depart_StationID")
    private Integer departStationID;
    @JsonProperty("CarriageID")
    private Integer carriageID;
    @JsonProperty("SeatNum")
    private Integer seatNum;
    @JsonProperty("SSN")
    private Integer sSN;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     *
     */
    public BookCancel() {
    }

    /**
     *
     * @param departStationID
     * @param routeID
     * @param seatNum
     * @param carriageID
     * @param arriveStationID
     * @param sSN
     */
    public BookCancel(Integer routeID, Integer arriveStationID, Integer departStationID, Integer carriageID, Integer seatNum, Integer sSN) {
        super();
        this.routeID = routeID;
        this.arriveStationID = arriveStationID;
        this.departStationID = departStationID;
        this.carriageID = carriageID;
        this.seatNum = seatNum;
        this.sSN = sSN;
    }

    @JsonProperty("RouteID")
    public Integer getRouteID() {
        return routeID;
    }

    @JsonProperty("RouteID")
    public void setRouteID(Integer routeID) {
        this.routeID = routeID;
    }

    @JsonProperty("Arrive_StationID")
    public Integer getArriveStationID() {
        return arriveStationID;
    }

    @JsonProperty("Arrive_StationID")
    public void setArriveStationID(Integer arriveStationID) {
        this.arriveStationID = arriveStationID;
    }

    @JsonProperty("Depart_StationID")
    public Integer getDepartStationID() {
        return departStationID;
    }

    @JsonProperty("Depart_StationID")
    public void setDepartStationID(Integer departStationID) {
        this.departStationID = departStationID;
    }

    @JsonProperty("CarriageID")
    public Integer getCarriageID() {
        return carriageID;
    }

    @JsonProperty("CarriageID")
    public void setCarriageID(Integer carriageID) {
        this.carriageID = carriageID;
    }

    @JsonProperty("SeatNum")
    public Integer getSeatNum() {
        return seatNum;
    }

    @JsonProperty("SeatNum")
    public void setSeatNum(Integer seatNum) {
        this.seatNum = seatNum;
    }

    @JsonProperty("SSN")
    public Integer getSSN() {
        return sSN;
    }

    @JsonProperty("SSN")
    public void setSSN(Integer sSN) {
        this.sSN = sSN;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
