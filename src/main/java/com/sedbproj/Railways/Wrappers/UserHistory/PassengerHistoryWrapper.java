package com.sedbproj.Railways.Wrappers.UserHistory;


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
        "Fname",
        "Lname",
        "ssn",
        "seatNum",
        "carriageId",
        "carriageType",
        "price"
})
public class PassengerHistoryWrapper {
    @JsonProperty("departTime")
    private String departureTime;
    @JsonProperty("arrivalTime")
    private String arrivalTime;
    @JsonProperty("departStation")
    private Integer departStation;
    @JsonProperty("arriveStation")
    private Integer arriveStation;
    @JsonProperty("Fname")
    private String fname;
    @JsonProperty("Lname")
    private String lname;
    @JsonProperty("ssn")
    private Long ssn;
    @JsonProperty("seatNum")
    private Integer seatNum;
    @JsonProperty("carriageId")
    private Integer carriageId;
    @JsonProperty("carriageType")
    private String carriageType;
    @JsonProperty("price")
    private Double price;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     *
     */
    public PassengerHistoryWrapper() {
    }

    /**
     *
     * @param fname
     * @param lname
     * @param seatNum
     * @param carriageType
     * @param price
     * @param carriageId
     * @param ssn
     */
    public PassengerHistoryWrapper(
            String arrivalTime,
            String departureTime,
            String fname,
            String lname,
            Long ssn,
            Integer seatNum,
            Integer carriageId,
            Integer arriveStation,
            Integer departStation,
            String carriageType,
            Double price
        ) {
        super();
        this.arrivalTime = arrivalTime;
        this.departureTime = departureTime;
        this.fname = fname;
        this.lname = lname;
        this.ssn = ssn;
        this.seatNum = seatNum;
        this.arriveStation = arriveStation;
        this.departStation = departStation;
        this.carriageId = carriageId;
        this.carriageType = carriageType;
        this.price = price;
    }

    @JsonProperty("departTime")
    public String getDepartureTime() {
        return departureTime;
    }
    @JsonProperty("departTime")
    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }
    @JsonProperty("arrivalTime")
    public String getArrivalTime() {
        return arrivalTime;
    }
    @JsonProperty("arrivalTime")
    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    @JsonProperty("departStation")
    public Integer getDepartStation() {
        return departStation;
    }
    @JsonProperty("departStation")
    public void setDepartStation(Integer departStation) {
        this.departStation = departStation;
    }
    @JsonProperty("arriveStation")
    public Integer getArriveStation() {
        return arriveStation;
    }
    @JsonProperty(value = "arriveStation")
    public void setArriveStation(Integer arriveStation) {
        this.arriveStation = arriveStation;
    }

    @JsonProperty("Fname")
    public String getFname() {
        return fname;
    }

    @JsonProperty("Fname")
    public void setFname(String fname) {
        this.fname = fname;
    }

    @JsonProperty("Lname")
    public String getLname() {
        return lname;
    }

    @JsonProperty("Lname")
    public void setLname(String lname) {
        this.lname = lname;
    }

    @JsonProperty("ssn")
    public Long getSsn() {
        return ssn;
    }

    @JsonProperty("ssn")
    public void setSsn(Long ssn) {
        this.ssn = ssn;
    }

    @JsonProperty("seatNum")
    public Integer getSeatNum() {
        return seatNum;
    }

    @JsonProperty("seatNum")
    public void setSeatNum(Integer seatNum) {
        this.seatNum = seatNum;
    }

    @JsonProperty("carriageId")
    public Integer getCarriageId() {
        return carriageId;
    }

    @JsonProperty("carriageId")
    public void setCarriageId(Integer carriageId) {
        this.carriageId = carriageId;
    }

    @JsonProperty("carriageType")
    public String getCarriageType() {
        return carriageType;
    }

    @JsonProperty("carriageType")
    public void setCarriageType(String carriageType) {
        this.carriageType = carriageType;
    }

    @JsonProperty("price")
    public Double getPrice() {
        return price;
    }

    @JsonProperty("price")
    public void setPrice(Double price) {
        this.price = price;
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