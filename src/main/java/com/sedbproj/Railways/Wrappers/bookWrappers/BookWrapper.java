
package com.sedbproj.Railways.Wrappers.bookWrappers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "RouteId",
    "ArrStationId",
    "DepStationId",
    "passengers"
})
public class BookWrapper {

    @JsonProperty("RouteId")
    private Integer routeId;
    @JsonProperty("ArrStationId")
    private Integer arrStationId;
    @JsonProperty("DepStationId")
    private Integer depStationId;
    @JsonProperty("passengers")
    private List<Passenger> passengers = null;
    @JsonProperty("UserId")
    private  Integer userId;

    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public BookWrapper() {
    }

    /**
     * 
     * @param arrStationId
     * @param passengers
     * @param routeId
     * @param depStationId
     */
    public BookWrapper(Integer routeId, Integer arrStationId, Integer depStationId, List<Passenger> passengers, Integer userId) {
        super();
        this.routeId = routeId;
        this.arrStationId = arrStationId;
        this.depStationId = depStationId;
        this.passengers = passengers;
        this.userId = userId;
    }

    @JsonProperty("RouteId")
    public Integer getRouteId() {
        return routeId;
    }

    @JsonProperty("RouteId")
    public void setRouteId(Integer routeId) {
        this.routeId = routeId;
    }

    @JsonProperty("ArrStationId")
    public Integer getArrStationId() {
        return arrStationId;
    }

    @JsonProperty("ArrStationId")
    public void setArrStationId(Integer arrStationId) {
        this.arrStationId = arrStationId;
    }

    @JsonProperty("DepStationId")
    public Integer getDepStationId() {
        return depStationId;
    }

    @JsonProperty("DepStationId")
    public void setDepStationId(Integer depStationId) {
        this.depStationId = depStationId;
    }

    @JsonProperty("passengers")
    public List<Passenger> getPassengers() {
        return passengers;
    }

    @JsonProperty("passengers")
    public void setPassengers(List<Passenger> passengers) {
        this.passengers = passengers;
    }

    @JsonProperty("UserId")
    public Integer getUserId() {
        return userId;
    }
    @JsonProperty("UserId")
    public void setUserId(Integer userId) {
        this.userId = userId;
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
