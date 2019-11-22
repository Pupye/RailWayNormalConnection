package com.sedbproj.Railways.Wrappers;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;
import java.util.Map;

public class StateCheckGet {
    @JsonProperty("RouteId")
    private Integer routeId;
    @JsonProperty("ArrStationId")
    private Integer arrStationId;
    @JsonProperty("DepStationId")
    private Integer depStationId;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     *
     */
    public StateCheckGet() {
    }

    /**
     *
     * @param arrStationId
     * @param routeId
     * @param depStationId
     */
    public StateCheckGet(Integer routeId, Integer arrStationId, Integer depStationId) {
        super();
        this.routeId = routeId;
        this.arrStationId = arrStationId;
        this.depStationId = depStationId;
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

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }
}
