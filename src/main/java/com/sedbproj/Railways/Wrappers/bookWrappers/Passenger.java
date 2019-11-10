
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
    "SSN",
    "bookInfo",
    "passengerInfo"
})
public class Passenger {

    @JsonProperty("SSN")
    private Long sSN;
    @JsonProperty("bookInfo")
    private BookInfo bookInfo;
    @JsonProperty("passengerInfo")
    private PassengerInfo passengerInfo;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Passenger() {
    }

    /**
     * 
     * @param bookInfo
     * @param passengerInfo
     * @param sSN
     */
    public Passenger(Long sSN, BookInfo bookInfo, PassengerInfo passengerInfo) {
        super();
        this.sSN = sSN;
        this.bookInfo = bookInfo;
        this.passengerInfo = passengerInfo;
    }

    @JsonProperty("SSN")
    public Long getSSN() {
        return sSN;
    }

    @JsonProperty("SSN")
    public void setSSN(Long sSN) {
        this.sSN = sSN;
    }

    @JsonProperty("bookInfo")
    public BookInfo getBookInfo() {
        return bookInfo;
    }

    @JsonProperty("bookInfo")
    public void setBookInfo(BookInfo bookInfo) {
        this.bookInfo = bookInfo;
    }

    @JsonProperty("passengerInfo")
    public PassengerInfo getPassengerInfo() {
        return passengerInfo;
    }

    @JsonProperty("passengerInfo")
    public void setPassengerInfo(PassengerInfo passengerInfo) {
        this.passengerInfo = passengerInfo;
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
