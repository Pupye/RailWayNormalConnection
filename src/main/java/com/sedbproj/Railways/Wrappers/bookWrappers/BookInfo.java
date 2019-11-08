
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
    "CarriageId",
    "SeatNum",
    "Price",
    "Adult"
})
public class BookInfo {

    @JsonProperty("CarriageId")
    private Integer carriageId;
    @JsonProperty("SeatNum")
    private Integer seatNum;
    @JsonProperty("Price")
    private double price;
    @JsonProperty("Adult")
    private Integer adult;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public BookInfo() {
    }

    /**
     * 
     * @param seatNum
     * @param price
     * @param carriageId
     * @param adult
     */
    public BookInfo(Integer carriageId, Integer seatNum, Integer price, Integer adult) {
        super();
        this.carriageId = carriageId;
        this.seatNum = seatNum;
        this.price = price;
        this.adult = adult;
    }

    @JsonProperty("CarriageId")
    public Integer getCarriageId() {
        return carriageId;
    }

    @JsonProperty("CarriageId")
    public void setCarriageId(Integer carriageId) {
        this.carriageId = carriageId;
    }

    @JsonProperty("SeatNum")
    public Integer getSeatNum() {
        return seatNum;
    }

    @JsonProperty("SeatNum")
    public void setSeatNum(Integer seatNum) {
        this.seatNum = seatNum;
    }

    @JsonProperty("Price")
    public double getPrice() {
        return price;
    }

    @JsonProperty("Price")
    public void setPrice(double price) {
        this.price = price;
    }

    @JsonProperty("Adult")
    public Integer getAdult() {
        return adult;
    }

    @JsonProperty("Adult")
    public void setAdult(Integer adult) {
        this.adult = adult;
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
