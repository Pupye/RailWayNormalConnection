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

    @JsonProperty("Fname")
    private String fname;
    @JsonProperty("Lname")
    private String lname;
    @JsonProperty("ssn")
    private Integer ssn;
    @JsonProperty("seatNum")
    private Integer seatNum;
    @JsonProperty("carriageId")
    private Integer carriageId;
    @JsonProperty("carriageType")
    private String carriageType;
    @JsonProperty("price")
    private Integer price;
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
    public PassengerHistoryWrapper(String fname, String lname, Integer ssn, Integer seatNum, Integer carriageId, String carriageType, Integer price) {
        super();
        this.fname = fname;
        this.lname = lname;
        this.ssn = ssn;
        this.seatNum = seatNum;
        this.carriageId = carriageId;
        this.carriageType = carriageType;
        this.price = price;
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
    public Integer getSsn() {
        return ssn;
    }

    @JsonProperty("ssn")
    public void setSsn(Integer ssn) {
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
    public Integer getPrice() {
        return price;
    }

    @JsonProperty("price")
    public void setPrice(Integer price) {
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